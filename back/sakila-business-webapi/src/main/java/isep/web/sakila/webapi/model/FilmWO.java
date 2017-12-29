package isep.web.sakila.webapi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import isep.web.sakila.jpa.entities.Film;

public class FilmWO extends WebObject {

	private static final long serialVersionUID = 4073820398936705L;

	protected int filmId;
	protected String title;
	protected String description;
	protected Date releaseYear;
	protected Date rentalDate;
	protected int rentalDuration;
	protected BigDecimal rentalRate;
	protected int length;

	public FilmWO() {
		super();
	}

	public FilmWO(final Film film) {
		super();
		this.filmId = film.getFilmId();
		this.title = film.getTitle();
		this.description = film.getDescription();
		this.releaseYear = film.getReleaseYear();
		this.rentalDuration = film.getRentalDuration();
		this.rentalRate = film.getRentalRate();
		this.length = film.getLength();
		this.rentalDate = new Timestamp(System.currentTimeMillis());
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString()
	{
		return "";
	}

}
