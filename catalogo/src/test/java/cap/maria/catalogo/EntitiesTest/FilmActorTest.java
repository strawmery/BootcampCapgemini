package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Entities.FilmActor;
import cap.maria.catalogo.Entities.FilmActorPK;

public class FilmActorTest {

	private FilmActor filmActor;

	@BeforeEach
	public void setUp() {
		filmActor = new FilmActor();
	}

	@Test
	public void testGetAndSetId() {
		FilmActorPK id = new FilmActorPK();
		filmActor.setId(id);
		assertEquals(id, filmActor.getId());
	}

	@Test
	public void testGetAndSetLastUpdate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		filmActor.setLastUpdate(timestamp);
		assertEquals(timestamp, filmActor.getLastUpdate());
	}

	@Test
	public void testGetAndSetActor() {
		Actor actor = new Actor();
		filmActor.setActor(actor);
		assertEquals(actor, filmActor.getActor());
	}

	@Test
	public void testGetAndSetFilm() {
		Film film = new Film();
		filmActor.setFilm(film);
		assertEquals(film, filmActor.getFilm());
	}
}