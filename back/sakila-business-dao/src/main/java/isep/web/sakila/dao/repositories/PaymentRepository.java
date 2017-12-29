package isep.web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
