package isep.web.sakila.webapi.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.RentalRepository;
import isep.web.sakila.dao.repositories.StaffRepository;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Rental;
import isep.web.sakila.webapi.model.CustomerWO;
import isep.web.sakila.webapi.model.FilmWO;
import isep.web.sakila.webapi.model.RentalWO;

@Service("rentalService")
@Transactional
public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StaffRepository staffRepository;

	private static final Log log= LogFactory.getLog(RentalServiceImpl.class);

	@Override
	public RentalWO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRental(RentalWO rentalWO) {
		Rental r = new Rental();
		r.setCustomer(customerRepository.findOne(rentalWO.getCustomerId()));
		r.setInventory(rentalWO.getInventory());
		r.setRentalDate(rentalWO.getRentalDate());
		r.setStaff(staffRepository.findOne(1));

		rentalRepository.save(r);
	}

	@Override
	public void updateRental(RentalWO rentalWO) {
		Rental r = rentalRepository.findOne(rentalWO.getRentailId());
		r.setReturnDate(rentalWO.getReturnDate());

		rentalRepository.save(r);
	}

	@Override
	public void deleteRentalById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RentalWO> findAllRentals() {
		List<RentalWO> rentals = new LinkedList<RentalWO>();

		for (Rental rental : rentalRepository.findAll())
		{
			rentals.add(new RentalWO(rental));
			log.debug("Adding " + rental);
		}

		return rentals;
	}

	@Override
	public List<FilmWO> findRentalsByCustomerId(int id) {
		List<FilmWO> rentals = new LinkedList<FilmWO>();

		for (Film rental : rentalRepository.findRentalsByCustomerId(id))
		{
			rentals.add(new FilmWO(rental));
			log.debug("Adding " + rental);
		}

		return rentals;
	}

	@Override
	public List<FilmWO> findNoRentedFilmsByCustomerId(int id) {
		List<FilmWO> rentals = new LinkedList<FilmWO>();

		for (Film rental : rentalRepository.findNoRentedFilmsByCustomerId(id))
		{
			rentals.add(new FilmWO(rental));
			log.debug("Adding " + rental);
		}

		return rentals;
	}

	@Override
	public RentalWO findRentalByCustomerAndFilmId(int customerId, int filmId) {
		log.debug(String.format("Looking for rental by Id"));
		Rental rental = rentalRepository.findRentalByCustomerAndFilmId(customerId, filmId);

		if (rental != null)
		{
			return new RentalWO(rental);
		}
		return null;
	}

}
