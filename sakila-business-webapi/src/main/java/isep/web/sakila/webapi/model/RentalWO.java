package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Rental;


public class RentalWO extends WebObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1188257012563723980L;
	
	protected int rentalId;
	protected Date rentalDate;
	protected Date returnDate;
	protected CustomerWO customer;
	
	public RentalWO() {
		super();
	}
	
	public RentalWO(int rentalId, Date rentalDate, Date returnDate)
	{
		this();
		this.rentalId = rentalId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}
	
	public RentalWO(final Rental rental) {
		this();
		this.rentalId = rental.getRentalId();
		this.rentalDate = rental.getRentalDate();
		this.returnDate = rental.getReturnDate();
	}
	
	public CustomerWO getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerWO customer) {
		this.customer = customer;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	
	public String toString() {
		return "Rental [id=" + this.rentalId + ", rentalDate=" 
				+ this.rentalDate + ", returnDate=" 
				+ this.returnDate + "]";
	}
	
	
}
