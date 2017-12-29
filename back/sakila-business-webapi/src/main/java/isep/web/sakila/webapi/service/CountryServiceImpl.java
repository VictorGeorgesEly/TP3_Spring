package isep.web.sakila.webapi.service;

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
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;

	private static final Log log= LogFactory.getLog(CountryServiceImpl.class);

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

	public List<CountryWO> findAllCountries()
	{
		List<CountryWO> countries = new LinkedList<CountryWO>();

		for (Country country : countryRepository.findAll())
		{
			countries.add(new CountryWO(country));
			log.debug("Adding " + country);
		}

		return countries;
	}
}
