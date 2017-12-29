package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isep.web.sakila.webapi.model.CityWO;
import isep.web.sakila.webapi.service.CityService;


@RestController
public class CityRestController {

	@Autowired
	CityService cityService;

	private static final Log log = LogFactory.getLog(CityRestController.class);

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/city/", method = RequestMethod.GET)
	public ResponseEntity<List<CityWO>> listAllActors()
	{
		List<CityWO> cities = cityService.findAllCities();
		if (cities.isEmpty())
		{
			return new ResponseEntity<List<CityWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CityWO>>(cities, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityWO> getActor(@PathVariable("id") int id)
	{
		System.out.println("Fetching City with id " + id);
		CityWO cityWO = cityService.findById(id);
		if (cityWO == null)
		{
			System.out.println("City with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CityWO>(cityWO, HttpStatus.OK);
	}
}
