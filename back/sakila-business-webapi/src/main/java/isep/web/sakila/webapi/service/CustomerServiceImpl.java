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
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.webapi.model.CustomerWO;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private StoreRepository storeRepository;

	private static final Log log= LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for customer by Id %s", id));
		Customer customer = customerRepository.findOne(id);

		if (customer != null)
		{
			return new CustomerWO(customer);
		}
		return null;
	}

	public List<CustomerWO> findAllCustomers()
	{
		List<CustomerWO> customers = new LinkedList<CustomerWO>();

		for (Customer customer : customerRepository.findAllOrderByLastName())
		{
			customers.add(new CustomerWO(customer));
			log.debug("Adding " + customer);
		}

		return customers;
	}

	public CustomerWO saveCustomer(CustomerWO customerWO)
	{

		Customer customer = new Customer();
		customer.setLastName(customerWO.getLastName());
		customer.setFirstName(customerWO.getFirstName());
		customer.setEmail(customerWO.getEmail());
		customer.setAddress(addressRepository.findOne(customerWO.getAddress().getAddressId()));
		customer.setStore(storeRepository.findOne(1));
		customer.setCreateDate(new Timestamp(System.currentTimeMillis()));
		customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		Customer c = customerRepository.save(customer);
		return (new CustomerWO(c));
	}

	public void updateCustomer(CustomerWO customerWO)
	{
		Customer customer2update = customerRepository.findOne(customerWO.getCustomerId());
		customer2update.setLastName(customerWO.getLastName());
		customer2update.setFirstName(customerWO.getFirstName());
		customer2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(customer2update);
	}

	@Override
	public void deleteCustomerById(int id)
	{
		customerRepository.delete(id);
	}

}
