package isep.web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.FilmText;

public interface FilmTextRepository extends CrudRepository<FilmText, Integer> {

}
