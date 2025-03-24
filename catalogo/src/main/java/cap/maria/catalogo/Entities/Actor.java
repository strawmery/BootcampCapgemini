package cap.maria.catalogo.Entities;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="actor")
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actor_id", unique=true, nullable=false)
	private int actorId;

	@NotBlank
	@Size(min = 1, max = 45, message = "Fisrt name must be between 1 and 45 characters")
	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@NotBlank
	@Size(min = 1, max = 45, message = "Last name must be between 1 and 45 characters")
	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

	@Column(name="last_update", insertable=false, updatable=false, nullable=false)
	@JsonIgnore
	private Timestamp lastUpdate;

	@OneToMany(mappedBy="actor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<FilmActor> filmActors;

	public Actor(int actorId, String firstName, String lastName) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setActor(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setActor(null);

		return filmActor;
	}
}