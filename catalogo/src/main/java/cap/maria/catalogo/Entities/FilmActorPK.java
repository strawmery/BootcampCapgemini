package cap.maria.catalogo.Entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The primary key class for the film_actor database table.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FilmActorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="actor_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int actorId;

	@Column(name="film_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int filmId;

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.actorId;
		hash = hash * prime + this.filmId;
		
		return hash;
	}
}