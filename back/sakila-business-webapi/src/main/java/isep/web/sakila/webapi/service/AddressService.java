package isep.web.sakila.webapi.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.webapi.model.AddressWO;

@Validated
public interface AddressService {

	AddressWO findById(int id);

	Address saveAddress(@NotNull AddressWO addressWO);

	Address updateAddress(AddressWO addressWO);

	List<AddressWO> findAllAddresses();
}
