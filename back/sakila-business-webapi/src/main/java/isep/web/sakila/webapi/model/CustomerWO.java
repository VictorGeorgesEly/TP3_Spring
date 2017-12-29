package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Customer;

public class CustomerWO extends WebObject {

	private static final long serialVersionUID = 3858239465219838338L;

	protected int customerId;
	protected String lastName;
	protected String firstName;
	protected String email;
	protected AddressWO address;
	protected int countryId;

	public CustomerWO() {
		super();
	}

	public CustomerWO(int customerId, String lastName, String firstName, String email) {
		super();
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	public CustomerWO(final Customer customer) {
		super();
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.email = customer.getEmail();
		this.address = new AddressWO(customer.getAddress());
		this.countryId = customer.getAddress().getCity().getCountry().getCountryId();
	}

	public String getFirstName() {
		return firstName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public AddressWO getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setAddress(AddressWO address) {
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + this.customerId + ", LastName=" + this.lastName + ", First=" + this.firstName +
				", Email=" + this.email + " " + this.address + "]";
	}

}
