package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.City;


public class CityWO extends WebObject {

	private static final long serialVersionUID = -810104683296886022L;

	private int cityId;
	private String city;
	private int countryId;

	public CityWO() {
		super();
	}

	public CityWO(int cityId, String city) {
		super();
		this.cityId= cityId;
		this.city=city;
	}

	public CityWO(final City city) {
		super();
		this.cityId= city.getCityId();
		this.city=city.getCity();
		this.countryId= city.getCountry().getCountryId();
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCountry() {
		return countryId;
	}

	public void setCountry(int countryId) {
		this.countryId = countryId;
	}

	public String getCity() {
		return city;
	}
  
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString()
	{
		return "Address [id=" + this.cityId + ", address=" + this.city +
				 " " + this.countryId +"]";
	}

}
