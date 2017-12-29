package isep.web.sakila.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class FilmActorPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="actor_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int actorId;

	@Column(name="film_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int filmId;

	public FilmActorPK() {
	}
	public int getActorId() {
		return this.actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getFilmId() {
		return this.filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FilmActorPK)) {
			return false;
		}
		FilmActorPK castOther = (FilmActorPK)other;
		return
			(this.actorId == castOther.actorId)
			&& (this.filmId == castOther.filmId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.actorId;
		hash = hash * prime + this.filmId;

		return hash;
	}
}
