package isep.web.sakila.webapi.controller;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.util.JSONPObject;

import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.webapi.model.FilmWO;
import isep.web.sakila.webapi.model.IdsWO;
import isep.web.sakila.webapi.model.InventoryWO;
import isep.web.sakila.webapi.model.RentalWO;
import isep.web.sakila.webapi.service.FilmService;
import isep.web.sakila.webapi.service.InventoryService;
import isep.web.sakila.webapi.service.RentalService;

@RestController
public class RentalRestController
{
	@Autowired
	RentalService rentalService;

	@Autowired
	FilmService filmService;

	@Autowired
	InventoryService inventoryService;

	private static final Log log = LogFactory.getLog(RentalRestController.class);

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/rental/", method = RequestMethod.GET)
	public ResponseEntity<List<RentalWO>> listAllRentals()
	{
		List<RentalWO> rentals = rentalService.findAllRentals();
		if (rentals.isEmpty())
		{
			log.debug(rentals);
			return new ResponseEntity<List<RentalWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalWO>>(rentals, HttpStatus.OK);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/rental/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RentalWO> getRental(@PathVariable("id") int id)
	{
		System.out.println("Fetching Rental with id " + id);
		RentalWO rentalWO = rentalService.findById(id);
		if (rentalWO == null)
		{
			System.out.println("Rental with id " + id + " not found");
			return new ResponseEntity<RentalWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RentalWO>(rentalWO, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customerRentals/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<FilmWO>> listRentalsById(@PathVariable("id") int id)
	{
		List<FilmWO> rentals = rentalService.findRentalsByCustomerId(id);
		if (rentals.isEmpty())
		{
			log.debug(rentals);
			return new ResponseEntity<List<FilmWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FilmWO>>(rentals, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/availableFilms/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<FilmWO>> listNoRentedFilmsById(@PathVariable("id") int id)
	{
		List<FilmWO> rentals = rentalService.findNoRentedFilmsByCustomerId(id);
		if (rentals.isEmpty())
		{
			log.debug(rentals);
			return new ResponseEntity<List<FilmWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FilmWO>>(rentals, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/rental/", method = RequestMethod.POST)
	public ResponseEntity<Void> createRental(@RequestBody IdsWO ids, UriComponentsBuilder ucBuilder)
	{
		System.out.println("Creating Rental");

		InventoryWO invent = new InventoryWO();
		invent.setFilmId(ids.getFilmId());
		invent.setStoreId(1);
		Inventory i = inventoryService.saveInventory(invent);


		RentalWO rent = new RentalWO();
		rent.setCustomerId(ids.getCustomerId());
		rent.setRentalDate(new Timestamp(System.currentTimeMillis()));
		rent.setStaffId(1);
		rent.setInventory(i);
		rentalService.saveRental(rent);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customerRentals/{id}").buildAndExpand(ids.getCustomerId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/rentalUpdate/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateRental(@RequestBody IdsWO ids, UriComponentsBuilder ucBuilder)
	{
		RentalWO rent = rentalService.findRentalByCustomerAndFilmId(ids.getCustomerId(), ids.getFilmId());

		if(rent == null) {
			System.out.println("Rental not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		rent.setReturnDate(new Timestamp(System.currentTimeMillis()));
		rentalService.updateRental(rent);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
