package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.jpa.entities.Rental;

public class RentalWO extends WebObject {

	private static final long serialVersionUID = -7784472822722713496L;

	protected int rentailId;
	protected Date rentalDate;
	protected Date returnDate; // nullable
	protected int customerId;
	protected int staffId;
	protected Inventory inventory;


	public RentalWO() {
		super();
	}

	public RentalWO(int id, Date rentalDate, int customerId, Inventory inventory) {
		super();
		this.rentailId = id;
		this.rentalDate = rentalDate;
		this.returnDate = null;
		this.customerId =customerId ;
		this.staffId = 1;
		this.inventory = inventory;

	}

	public RentalWO(final Rental rental) {
		super();
		this.rentailId = rental.getRentalId();
		this.rentalDate = rental.getRentalDate();
		this.returnDate = rental.getReturnDate();
		this.customerId =rental.getCustomer().getCustomerId() ;
		this.staffId = 1;
		this.inventory = rental.getInventory();
	}


	public int getRentailId() {
		return rentailId;
	}

	public void setRentailId(int rentailId) {
		this.rentailId = rentailId;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString()
	{
		return "";
	}

}
