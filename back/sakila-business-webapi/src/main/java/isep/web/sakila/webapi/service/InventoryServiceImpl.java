package isep.web.sakila.webapi.service;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.dao.repositories.InventoryRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Inventory;
import isep.web.sakila.webapi.model.InventoryWO;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private StoreRepository storeRepository;

	private static final Log log= LogFactory.getLog(RentalServiceImpl.class);

	@Override
	public Inventory saveInventory(InventoryWO inventWO) {
		Inventory invent = new Inventory();
		invent.setFilm(filmRepository.findOne(inventWO.getFilmId()));
		invent.setStore(storeRepository.findOne(inventWO.getStoreId()));
		invent.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		Inventory i = inventoryRepository.save(invent);
		return i;
	}

	@Override
	public Inventory findById(int id) {
		log.debug(String.format("Looking for inventory by Id %s", id));
		Inventory invent = inventoryRepository.findOne(id);

		if (invent != null)
		{
			return invent;
		}
		return null;
	}

}
