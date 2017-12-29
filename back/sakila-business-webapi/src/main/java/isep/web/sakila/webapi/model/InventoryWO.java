package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Inventory;

public class InventoryWO extends WebObject{

	private static final long serialVersionUID = 8022142672944572088L;

	protected int inventoryId;
	protected int filmId;
	protected int storeId;

	public InventoryWO() {
		super();
	}

	public InventoryWO(int id, int customerId, int filmId) {
		super();
		this.storeId = 1;
		this.inventoryId = id;
		this.filmId = filmId;

	}

	public InventoryWO(final Inventory invent) {
		super();
		this.storeId = 1;
		this.inventoryId = invent.getInventoryId();
		this.filmId = invent.getFilm().getFilmId();
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getStoreId() {
		return storeId;
	}
  
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
