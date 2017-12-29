package isep.web.sakila.webapi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.webapi.model.FilmWO;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	private static final Log log= LogFactory.getLog(FilmServiceImpl.class);

	@Override
	public FilmWO findById(int id) {
		log.debug(String.format("Looking for film by Id %s", id));
		Film f = filmRepository.findOne(id);

		if (f != null)
		{
			return new FilmWO(f);
		}
		return null;
	}

}
