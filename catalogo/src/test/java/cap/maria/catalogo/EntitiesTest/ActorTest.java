package cap.maria.catalogo.EntitiesTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Entities.FilmActor;

public class ActorTest {

	private Actor actor;

	@BeforeEach
	public void setUp() {
		actor = new Actor();
	}

	@Test
	public void testGetAndSetActorId() {
		actor.setActorId(1);
		assertEquals(1, actor.getActorId());
	}

	@Test
	public void testGetAndSetFirstName() {
		actor.setFirstName("John");
		assertEquals("John", actor.getFirstName());
	}

	@Test
	public void testGetAndSetLastName() {
		actor.setLastName("Doe");
		assertEquals("Doe", actor.getLastName());
	}

	@Test
	public void testGetAndSetLastUpdate() {
		Date date = new Date(System.currentTimeMillis());
		actor.setLastUpdate(date);
		assertEquals(date, actor.getLastUpdate());
	}

	@Test
	public void testGetAndSetFilmActors() {
		List<FilmActor> filmActors = new ArrayList<>();
		actor.setFilmActors(filmActors);
		assertEquals(filmActors, actor.getFilmActors());
	}

	@Test
	public void testAddFilmActor() {
		FilmActor filmActor = new FilmActor();
		actor.setFilmActors(new ArrayList<>());
		actor.addFilmActor(filmActor);
		assertTrue(actor.getFilmActors().contains(filmActor));
		assertEquals(actor, filmActor.getActor());
	}

	@Test
	public void testRemoveFilmActor() {
		FilmActor filmActor = new FilmActor();
		actor.setFilmActors(new ArrayList<>());
		actor.addFilmActor(filmActor);
		actor.removeFilmActor(filmActor);
		assertFalse(actor.getFilmActors().contains(filmActor));
		assertNull(filmActor.getActor());
	}

	@Test
	public void testToString() {
		actor.setActorId(1);
		actor.setFirstName("John");
		actor.setLastName("Doe");
		Date date = new Date(System.currentTimeMillis());
		actor.setLastUpdate(date);
		String expected = "Actor(actorId=1, firstName=John, lastName=Doe, lastUpdate=" + date + ", filmActors=null)";
		assertEquals(expected, actor.toString());
	}
}