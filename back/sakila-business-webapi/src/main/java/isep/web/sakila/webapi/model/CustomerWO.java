package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Customer;

public class CustomerWO extends WebObject {

	private static final long serialVersionUID = -3940626561941477764L;
	
	protected int customerId;
	protected String	 lastName;
	protected String	 firstName;
	protected String email;
	protected AddressWO address;
	protected StoreWO store;
	
	public CustomerWO() {
		super();
	}
	
	public CustomerWO(int customerId, String lastName, String firstName, String email)
	{
		this();
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}
	
	public CustomerWO(final Customer customer) {
		this();
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.email = customer.getEmail();
	}
	

	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public AddressWO getAddress() {
		return address;
	}
	
	public void setAddress(AddressWO address) {
		this.address = address;
	}
	
	public StoreWO getStore() {
		return store;
	}
	
	public void setStore(StoreWO store) {
		this.store = store;
	}
	
	@Override
	public String toString()
	{
		return "Customer [id=" + this.customerId + ", LastNanem=" 
				+ this.lastName + ", First=" + this.firstName + ", email=" + this.email
				+ ", address=" + this.address + ", store=" + this.store + "]";
	}
}
