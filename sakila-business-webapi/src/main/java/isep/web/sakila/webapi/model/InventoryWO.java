package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Inventory;

public class InventoryWO extends WebObject {

	private static final long serialVersionUID = 8022142672944572088L;

	protected int inventoryId;

	protected StoreWO storeWO;
	protected FilmWO filmWO;

	InventoryWO() {
		super();
	}

	public InventoryWO(int inventoryId)
	{
		this();
		this.inventoryId = inventoryId;
	}

	public InventoryWO(final Inventory inventory) {
		this();
		this.inventoryId = inventory.getInventoryId();
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public StoreWO getStoreWO() {
		return storeWO;
	}

	public void setStoreWO(StoreWO storeWO) {
		this.storeWO = storeWO;
	}

	public FilmWO getFilmWO() {
		return filmWO;
	}

	public void setFilmWO(FilmWO filmWO) {
		this.filmWO = filmWO;
	}

	public String toString() {
		return "Rental [id=" + this.inventoryId + "]";
	}
}
