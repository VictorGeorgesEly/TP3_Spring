package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.Staff;

public class StaffWO extends WebObject {
	
	private static final long serialVersionUID = -8820948281850630097L;
	
	protected String username;
	protected String password;
	
	
	public StaffWO() {
		super();
	}
	
	public StaffWO(byte staffId, String firstName, String lastName, byte[] picture, String email, byte storeId, StoreWO store, byte active, String username, String password, Address address) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public StaffWO(Staff staff) {
		super();
		this.username = staff.getUsername();
		this.password = staff.getPassword();

	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

}
