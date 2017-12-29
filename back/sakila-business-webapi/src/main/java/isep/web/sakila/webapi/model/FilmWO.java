package isep.web.sakila.webapi.model;

import java.math.BigDecimal;
import java.util.Date;

import isep.web.sakila.jpa.entities.Film;

public class FilmWO extends WebObject {

	private static final long serialVersionUID = -8494386839845787279L;

	private int filmId;
	private String description;
	private int length;
	private String rating;
	private Date releaseYear;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private BigDecimal replacementCost;
	private String specialFeatures;
	private String title;
	private LanguageWO language1;
	private LanguageWO language2;

	public FilmWO() {
		super();
	}

	public FilmWO(final Film film) {
		this();
		this.filmId = film.getFilmId();
		this.description = film.getDescription();
		this.length = film.getLength();
		this.rating = film.getRating();
		this.releaseYear = film.getReleaseYear();
		this.rentalDuration = film.getRentalDuration();
		this.rentalRate = film.getRentalRate();
		this.replacementCost = film.getReplacementCost();
		this.specialFeatures = film.getSpecialFeatures();
		this.title = film.getTitle();
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public byte getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LanguageWO getLanguage1() {
		return language1;
	}

	public void setLanguage1(LanguageWO language1) {
		this.language1 = language1;
	}

	public LanguageWO getLanguage2() {
		return language2;
	}

	public void setLanguage2(LanguageWO language2) {
		this.language2 = language2;
	}

	public String toString() {
		return "Film [id=" + this.filmId + ", description="
				+ this.description + ", length="
				+ this.length + ", rating=" + this.rating
				+ ", releaseYear=" + this.releaseYear +
				", rentalDuration=" + this.rentalDuration +
				", rentalRate=" + this.rentalRate + ", replacementCost="
				+ this.replacementCost + ", specialFeatures="
				+ this.specialFeatures + ", title=" + this.title + "]";
	}
}
