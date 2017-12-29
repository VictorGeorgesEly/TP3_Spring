package isep.web.sakila.webapi.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import isep.web.sakila.webapi.model.CustomerWO;

@Validated
public interface CustomerService {

	CustomerWO findById(int id);

	CustomerWO saveCustomer(@NotNull CustomerWO customerWO);

	void updateCustomer(CustomerWO customerWO);

	void deleteCustomerById(int id);

	List<CustomerWO> findAllCustomers();
}
