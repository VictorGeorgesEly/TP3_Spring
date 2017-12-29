package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Country;

public class CountryWO extends WebObject {
	
	private static final long serialVersionUID = -8820948281850630097L;
	
	protected int countryId;
	protected String country;
	
	public CountryWO() {
		super();
	}
	
	public CountryWO(int countryId, String country) {
		this();
		this.countryId = countryId;
		this.country = country;
	}
	
	public CountryWO(Country country) {
		this();
		this.countryId = country.getCountryId();
		this.country = country.getCountry();
	}
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "Country [id=" + this.countryId + ", country=" 
				+ this.country + "]";
	}
}
