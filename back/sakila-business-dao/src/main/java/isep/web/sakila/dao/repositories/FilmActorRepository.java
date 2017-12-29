package isep.web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.FilmActor;
import isep.web.sakila.jpa.entities.FilmActorPK;

public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorPK> {

}
