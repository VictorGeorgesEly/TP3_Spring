package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.Store;

public class StoreWO extends WebObject {
	
	private static final long serialVersionUID = -8820948281850630097L;
	
	protected int storeId;
	protected AddressWO address;
	
	public StoreWO() {
		super();
	}
	
	public StoreWO(int storeId, Address address) {
		this();
		this.storeId = storeId;
		this.address = new AddressWO(address);
	}
	
	public StoreWO(Store store) {
		this();
		this.storeId = store.getStoreId();
		this.address = new AddressWO(store.getAddress());
	}
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public AddressWO getAddress() {
		return address;
	}
	
	public void setAddress(AddressWO address) {
		this.address = address;
	}

	public String toString() {
		return "Country [id=" + this.storeId + "]";
	}
}
