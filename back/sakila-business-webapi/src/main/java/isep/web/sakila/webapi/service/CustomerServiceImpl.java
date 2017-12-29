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
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.webapi.model.AddressWO;
import isep.web.sakila.webapi.model.CustomerWO;
import isep.web.sakila.webapi.model.StoreWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StoreRepository storeRepository;

	private static final Log	log	= LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<CustomerWO> findAllCustomers() {
		List<CustomerWO> customers = new LinkedList<CustomerWO>();
		CustomerWO currentCustomer = null;
		for (Customer customer : customerRepository.findAll()) {
			currentCustomer = new CustomerWO(customer);
			currentCustomer.setAddress(new AddressWO(customer.getAddress()));
			currentCustomer.setStore(new StoreWO(customer.getStore()));
			customers.add(currentCustomer);
			log.debug("Customer : " + customer);
		}
		return customers;
	}

	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Customer customer = customerRepository.findOne(id);

		if (customer != null)
		{
			return new CustomerWO(customer);
		}
		return null;
	}

	@Override
	public void saveCustomer(CustomerWO userWO) {
		System.out.println(userWO);
		Customer customer = new Customer();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		customer.setLastName(userWO.getLastName());
		customer.setFirstName(userWO.getFirstName());
		customer.setEmail(userWO.getEmail());
		if (userWO.getAddress() !=null) {
			saveAddress(userWO.getAddress());
			customer.setAddress(addressRepository.findOne(userWO.getAddress().getAddressId()));
		}
		if (userWO.getStore()!=null) {
			customer.setStore(storeRepository.findOne(userWO.getStore().getStoreId()));
		}
		customer.setCreateDate(time);
		customer.setLastUpdate(time);
		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(CustomerWO userWO) {
		System.out.println(userWO);
		Customer customer = customerRepository.findOne(userWO.getCustomerId());
		Timestamp time = new Timestamp(System.currentTimeMillis());
		customer.setLastName(userWO.getLastName());
		customer.setFirstName(userWO.getFirstName());
		customer.setEmail(userWO.getEmail());
		if (userWO.getAddress() !=null) {
			saveAddress(userWO.getAddress());
			customer.setAddress(addressRepository.findOne(userWO.getAddress().getAddressId()));
		}
		if (userWO.getStore()!=null) {
			customer.setStore(storeRepository.findOne(userWO.getStore().getStoreId()));
		}
		customer.setCreateDate(time);
		customer.setLastUpdate(time);
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		log.debug(String.format("Delete user with Id %s", id));
		customerRepository.delete(id);
	}

	private void saveAddress(AddressWO addressWO) {
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

}
