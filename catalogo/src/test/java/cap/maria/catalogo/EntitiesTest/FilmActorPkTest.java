package cap.maria.catalogo.EntitiesTest;

import cap.maria.catalogo.Entities.FilmActorPK;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FilmActorPkTest {

	@Test
	public void testDefaultConstructor() {
		FilmActorPK filmActorPK = new FilmActorPK();
		assertNotNull(filmActorPK);
	}

	@Test
	public void testParameterizedConstructor() {
		FilmActorPK filmActorPK = new FilmActorPK();
		filmActorPK.setActorId(1);
		filmActorPK.setFilmId(2);
		assertEquals(1, filmActorPK.getActorId());
		assertEquals(2, filmActorPK.getFilmId());
	}

	// @Test
	// public void testEquals() {
	// 	FilmActorPK filmActorPK1 = new FilmActorPK();
	// 	filmActorPK1.setActorId(1);
	// 	filmActorPK1.setFilmId(2);

	// 	FilmActorPK filmActorPK2 = new FilmActorPK();
	// 	filmActorPK2.setActorId(1);
	// 	filmActorPK2.setFilmId(2);

	// 	// assertTrue(filmActorPK1.equals(filmActorPK2));
	// 	assertTrue(filmActorPK2.equals(filmActorPK1));
	// }

	@Test
	public void testNotEquals() {
		FilmActorPK filmActorPK1 = new FilmActorPK();
		filmActorPK1.setActorId(1);
		filmActorPK1.setFilmId(2);

		FilmActorPK filmActorPK2 = new FilmActorPK();
		filmActorPK2.setActorId(2);
		filmActorPK2.setFilmId(3);

		assertFalse(filmActorPK1.equals(filmActorPK2));
		assertFalse(filmActorPK2.equals(filmActorPK1));
	}

	@Test
	public void testHashCode() {
		FilmActorPK filmActorPK1 = new FilmActorPK();
		filmActorPK1.setActorId(1);
		filmActorPK1.setFilmId(2);

		FilmActorPK filmActorPK2 = new FilmActorPK();
		filmActorPK2.setActorId(1);
		filmActorPK2.setFilmId(2);

		assertEquals(filmActorPK1.hashCode(), filmActorPK2.hashCode());
	}

	@Test
	public void testHashCodeNotEquals() {
		FilmActorPK filmActorPK1 = new FilmActorPK();
		filmActorPK1.setActorId(1);
		filmActorPK1.setFilmId(2);

		FilmActorPK filmActorPK2 = new FilmActorPK();
		filmActorPK2.setActorId(2);
		filmActorPK2.setFilmId(3);

		assertNotEquals(filmActorPK1.hashCode(), filmActorPK2.hashCode());
	}

	@Test
	public void testGettersAndSetters() {
		FilmActorPK filmActorPK = new FilmActorPK();
		filmActorPK.setActorId(1);
		filmActorPK.setFilmId(2);

		assertEquals(1, filmActorPK.getActorId());
		assertEquals(2, filmActorPK.getFilmId());
	}
}
