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

import isep.web.sakila.webapi.model.CountryWO;
import isep.web.sakila.webapi.service.CountryService;

@RestController
public class CountryRestController
{
	@Autowired
	CountryService countryService;

	private static final Log log = LogFactory.getLog(CountryRestController.class);

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/country/", method = RequestMethod.GET)
	public ResponseEntity<List<CountryWO>> listAllCountries()
	{
		List<CountryWO> countries = countryService.findAllCountries();
		if (countries.isEmpty())
		{
			return new ResponseEntity<List<CountryWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CountryWO>>(countries, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountryWO> getCountry(@PathVariable("id") int id)
	{
		System.out.println("Fetching Country with id " + id);
		CountryWO countryWO = countryService.findById(id);
		if (countryWO == null)
		{
			System.out.println("Country with id " + id + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CountryWO>(countryWO, HttpStatus.OK);
	}

}
