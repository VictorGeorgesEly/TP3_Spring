package isep.web.sakila.webapi.model;

import java.util.ArrayList;
import java.util.List;

import isep.web.sakila.jpa.entities.Country;
import isep.web.sakila.jpa.entities.City;

public class CountryWO extends WebObject {

	private static final long serialVersionUID = -8820948281850630097L;

	private int countryId;
	private String country;
	private List<CityWO> cities;

	public CountryWO() {
		super();
	}

	public CountryWO(int countryId, String country) {
		super();
		this.countryId = countryId;
		this.country = country;
	}

	public CountryWO(final Country country) {
		super();
		this.countryId = country.getCountryId();
		this.country = country.getCountry();
		this.cities = new ArrayList<>();

		for(City c : country.getCities()) {
			this.cities.add(new CityWO(c));
		}

	}

	public int getCountryId() {
		return countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<CityWO> getCities() {
		return cities;
	}

	public void setCities(List<CityWO> cities) {
		this.cities = cities;
	}

	@Override
	public String toString()
	{
		return "Country [id=" + this.countryId + ", country=" + this.country + "]";
	}

}
