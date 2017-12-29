package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.webapi.model.AddressWO;
import isep.web.sakila.webapi.model.CustomerWO;
import isep.web.sakila.webapi.service.AddressService;
import isep.web.sakila.webapi.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController
{

	@Autowired
	CustomerService customerService;

	@Autowired
	AddressService addressService;

	private static final Log log = LogFactory.getLog(CustomerRestController.class);

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerWO>> listAllCustomers()
	{
		List<CustomerWO> customers = customerService.findAllCustomers();
		if (customers.isEmpty())
		{
			return new ResponseEntity<List<CustomerWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CustomerWO>>(customers, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerWO> getCustomer(@PathVariable("id") int id)
	{
		System.out.println("Fetching Customer with id " + id);
		CustomerWO customerWO = customerService.findById(id);
		if (customerWO == null)
		{
			System.out.println("Customer with id " + id + " not found");
			return new ResponseEntity<CustomerWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomerWO>(customerWO, HttpStatus.OK);
	}

	// -------------------Create a Customer----------------------------------

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customer/", method = RequestMethod.POST)
	public ResponseEntity<CustomerWO> createCustomer(@RequestBody CustomerWO customerWO, UriComponentsBuilder ucBuilder)
	{
		System.out.println("Creating Customer " + customerWO.toString());

		Address newAddress = addressService.saveAddress(customerWO.getAddress());
		customerWO.setAddress(new AddressWO(newAddress));

		CustomerWO newCustomer = customerService.saveCustomer(customerWO);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<CustomerWO>(newCustomer, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customerUpdate/", method = RequestMethod.PUT)
	public ResponseEntity<CustomerWO> updateCustomer(@RequestBody CustomerWO customerWO, UriComponentsBuilder ucBuilder)
	{
		log.error(String.format("Updating Customer %s ", customerWO.getCustomerId()));
		CustomerWO currentCustomer = customerService.findById(customerWO.getCustomerId());

		if (currentCustomer == null)
		{
			System.out.println("Customer with id " + customerWO.getCustomerId() + " not found");
			return new ResponseEntity<CustomerWO>(HttpStatus.NOT_FOUND);
		}

		AddressWO address = addressService.findById(currentCustomer.getAddress().getAddressId());

		if (address == null)
		{
			System.out.println("Address with id " + customerWO.getAddress().getAddressId() + " not found");
			return new ResponseEntity<CustomerWO>(HttpStatus.NOT_FOUND);
		}

		address.setAddress(customerWO.getAddress().getAddress());
		address.setAddress2(customerWO.getAddress().getAddress2());
		address.setDistrict(customerWO.getAddress().getDistrict());
		address.setPhone(customerWO.getAddress().getPhone());
		address.setPostalCode(customerWO.getAddress().getPostalCode());
		address.setCityId(customerWO.getAddress().getCityId());
		addressService.updateAddress(address);

		currentCustomer.setLastName(customerWO.getLastName());
		currentCustomer.setFirstName(customerWO.getFirstName());
		currentCustomer.setEmail(customerWO.getEmail());
		customerService.updateCustomer(currentCustomer);

		return new ResponseEntity<CustomerWO>(currentCustomer, HttpStatus.OK);
	}
  
}
