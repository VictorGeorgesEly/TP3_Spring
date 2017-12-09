package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;

public class AddressWO extends WebObject {

	private static final long serialVersionUID = -7229516342336576816L;
	
	protected int addressId;
	protected String address;
	protected String address2;
	protected String district;
	protected String postalCode;
	protected String phone;
	protected CityWO city;
	
	public AddressWO() {
		super();
	}
	
	public AddressWO(int addressId, String address, String address2, String district, String phone, City city) {
		this();
		this.addressId = addressId;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.phone = phone;
		this.city = new CityWO(city);
	}
	
	public AddressWO(Address address) {
		this();
		this.addressId = address.getAddressId();
		this.address = address.getAddress();
		this.address2 = address.getAddress2();
		this.district = address.getDistrict();
		this.phone = address.getPhone();
		this.city = new CityWO(address.getCity());
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CityWO getCity() {
		return city;
	}

	public void setCity(CityWO city) {
		this.city = city;
	}

	@Override
	public String toString()
	{
		return "Address [id=" + this.addressId + ", address=" 
				+ this.address + ", address2=" + this.address2 
				+ ", district=" + this.district + ", phone="+ this.phone + "]";
	}
}
