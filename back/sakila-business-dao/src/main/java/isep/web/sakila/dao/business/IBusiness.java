package isep.web.sakila.dao.business;

import java.util.List;

import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Rental;

public interface IBusiness
{
	public List<Actor> getAllActors();

	public Actor getByID(int actorId);

	public List<Rental> getAllRentals();

	public Rental getrRentalByID(int actorId);

}
