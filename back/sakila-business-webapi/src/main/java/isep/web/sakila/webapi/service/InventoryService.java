package isep.web.sakila.webapi.service;

import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.webapi.model.InventoryWO;

public interface InventoryService {

	Inventory findById(int id);

	Inventory saveInventory(InventoryWO inventoryWO);

}
