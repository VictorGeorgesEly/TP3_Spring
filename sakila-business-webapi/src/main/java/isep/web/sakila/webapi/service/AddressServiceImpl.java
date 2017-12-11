package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.AddressRepository;
import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.webapi.model.AddressWO;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CityRepository cityRepository;

	private static final Log	log	= LogFactory.getLog(AddressServiceImpl.class);

	@Override
	public List<AddressWO> findAllAddresses() {
		List<AddressWO> addresses = new LinkedList<AddressWO>();
		for (Address address : addressRepository.findAll()) {
			addresses.add(new AddressWO(address));
			log.debug("Address : " + address);
		}
		return addresses;
	}

	@Override
	public AddressWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Address address = addressRepository.findOne(id);

		if (address != null)
		{
			return new AddressWO(address);
		}
		return null;
	}

	@Override
	public void saveAddress(AddressWO addressWO) {
		Address address = new Address();
		City city = null;
		Timestamp time = new Timestamp(System.currentTimeMillis());
		address.setAddress(addressWO.getAddress());
		address.setAddress2(addressWO.getAddress2());
		address.setDistrict(addressWO.getDistrict());
		address.setPostalCode(addressWO.getPostalCode());
		address.setPhone(addressWO.getPhone());
		city = cityRepository.findOneByCity(addressWO.getCity().getCity());
		address.setCity(city);
		address.setLastUpdate(time);
		addressRepository.save(address);
	}

	@Override
	public void updateAddress(AddressWO addressWO) {
		Address address = addressRepository.findOne(addressWO.getAddressId());
		City city = null;
		Timestamp time = new Timestamp(System.currentTimeMillis());
		address.setAddress(addressWO.getAddress());
		address.setAddress2(addressWO.getAddress2());
		address.setDistrict(addressWO.getDistrict());
		address.setPostalCode(addressWO.getPostalCode());
		address.setPhone(addressWO.getPhone());
		city = cityRepository.findOneByCity(addressWO.getCity().getCity());
		address.setCity(city);
		address.setLastUpdate(time);
		addressRepository.save(address);
	}

	@Override
	public void deleteAddressById(int id) {
		log.debug(String.format("Delete address with Id %s", id));
		addressRepository.delete(id);
	}
}
