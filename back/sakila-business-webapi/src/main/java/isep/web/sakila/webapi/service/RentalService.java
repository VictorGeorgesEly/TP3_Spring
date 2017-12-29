package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.FilmWO;
import isep.web.sakila.webapi.model.RentalWO;

public interface RentalService {

	RentalWO findById(int id);

	void saveRental(RentalWO rentalWO);

	void updateRental(RentalWO rentalWO);

	void deleteRentalById(int id);

	List<RentalWO> findAllRentals();

	List<FilmWO> findRentalsByCustomerId(int id);

	List<FilmWO> findNoRentedFilmsByCustomerId(int id);

	RentalWO findRentalByCustomerAndFilmId(int customerId, int filmId);
}
