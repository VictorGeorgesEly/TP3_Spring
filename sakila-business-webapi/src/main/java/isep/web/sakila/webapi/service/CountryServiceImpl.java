package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.CountryRepository;
import isep.web.sakila.jpa.entities.Country;
import isep.web.sakila.webapi.model.CountryWO;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepository;

	private static final Log	log	= LogFactory.getLog(CountryServiceImpl.class);

	@Override
	public List<CountryWO> findAllCountries() {
		List<CountryWO> countries = new LinkedList<CountryWO>();
		CountryWO currentCountry = null;
		for (Country country : countryRepository.findAll()) {
			currentCountry = new CountryWO(country);
			countries.add(currentCountry);
			log.debug("Country : " + country);
		}
		return countries;
	}

	@Override
	public CountryWO findById(int id) {
		log.debug(String.format("Looking for country by Id %s", id));
		Country country = countryRepository.findOne(id);

		if (country != null)
		{
			return new CountryWO(country);
		}
		return null;
	}

	@Override
	public void saveCountry(CountryWO countryWO) {
		Country country = new Country();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		country.setCountry(countryWO.getCountry());
		country.setLastUpdate(time);
		countryRepository.save(country);
	}

	@Override
	public void updateCountry(CountryWO countryWO) {
		Country country = countryRepository.findOne(countryWO.getCountryId());
		Timestamp time = new Timestamp(System.currentTimeMillis());
		country.setCountry(countryWO.getCountry());
		country.setLastUpdate(time);
		countryRepository.save(country);
	}

	@Override
	public void deleteCountryById(int id) {
		log.debug(String.format("Delete country with Id %s", id));
		countryRepository.delete(id);
	}

}
