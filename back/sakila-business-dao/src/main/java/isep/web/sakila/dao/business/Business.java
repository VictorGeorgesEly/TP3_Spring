package isep.web.sakila.dao.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import isep.web.sakila.dao.repositories.ActorRepository;
import isep.web.sakila.dao.repositories.RentalRepository;
import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Rental;

@Service("business")
public class Business implements IBusiness
{
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private RentalRepository rentalRepository;

	@Override
	public List<Actor> getAllActors()
	{
		return Lists.newArrayList(actorRepository.findAll());
	}

	public Actor getByID(int actorId)
	{
		return actorRepository.findOne(actorId);
	}

	@Override
	public List<Rental> getAllRentals() {
		return Lists.newArrayList(rentalRepository.findAll());
	}

	@Override
	public Rental getrRentalByID(int actorId) {
		return rentalRepository.findOne(actorId);
	}
}
