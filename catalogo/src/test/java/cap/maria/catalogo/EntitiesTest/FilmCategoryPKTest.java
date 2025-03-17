package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import cap.maria.catalogo.Entities.FilmCategoryPK;



public class FilmCategoryPKTest {

	@Test
	void testDefaultConstructor() {
		FilmCategoryPK filmCategoryPK = new FilmCategoryPK();
		assertNotNull(filmCategoryPK);
	}

	@Test
	void testParameterizedConstructor() {
		FilmCategoryPK filmCategoryPK = new FilmCategoryPK();
		filmCategoryPK.setFilmId(1);
		filmCategoryPK.setCategoryId(2);
		assertAll("Constructor",
			() -> assertEquals(1, filmCategoryPK.getFilmId(), "filmId"),
			() -> assertEquals(2, filmCategoryPK.getCategoryId(), "categoryId"));
	}

	@Test
	void testEquals() {
		FilmCategoryPK filmCategoryPK1 = new FilmCategoryPK();
		filmCategoryPK1.setFilmId(1);
		filmCategoryPK1.setCategoryId(2);

		FilmCategoryPK filmCategoryPK2 = new FilmCategoryPK();
		filmCategoryPK2.setFilmId(1);
		filmCategoryPK2.setCategoryId(2);

		assertTrue(filmCategoryPK1.equals(filmCategoryPK2));
		assertTrue(filmCategoryPK2.equals(filmCategoryPK1));
	}

	@Test
	void testNotEquals() {
		FilmCategoryPK filmCategoryPK1 = new FilmCategoryPK();
		filmCategoryPK1.setFilmId(1);
		filmCategoryPK1.setCategoryId(2);

		FilmCategoryPK filmCategoryPK2 = new FilmCategoryPK();
		filmCategoryPK2.setFilmId(2);
		filmCategoryPK2.setCategoryId(3);

		assertFalse(filmCategoryPK1.equals(filmCategoryPK2));
		assertFalse(filmCategoryPK2.equals(filmCategoryPK1));
	}

	@Test
	void testHashCode() {
		FilmCategoryPK filmCategoryPK1 = new FilmCategoryPK();
		filmCategoryPK1.setFilmId(1);
		filmCategoryPK1.setCategoryId(2);

		FilmCategoryPK filmCategoryPK2 = new FilmCategoryPK();
		filmCategoryPK2.setFilmId(1);
		filmCategoryPK2.setCategoryId(2);

		assertEquals(filmCategoryPK1.hashCode(), filmCategoryPK2.hashCode());
	}

	@Test
	void testHashCodeNotEquals() {
		FilmCategoryPK filmCategoryPK1 = new FilmCategoryPK();
		filmCategoryPK1.setFilmId(1);
		filmCategoryPK1.setCategoryId(2);

		FilmCategoryPK filmCategoryPK2 = new FilmCategoryPK();
		filmCategoryPK2.setFilmId(2);
		filmCategoryPK2.setCategoryId(3);

		assertNotEquals(filmCategoryPK1.hashCode(), filmCategoryPK2.hashCode());
	}

	@Test
	void testGettersAndSetters() {
		FilmCategoryPK filmCategoryPK = new FilmCategoryPK();
		filmCategoryPK.setFilmId(1);
		filmCategoryPK.setCategoryId(2);

		assertEquals(1, filmCategoryPK.getFilmId());
		assertEquals(2, filmCategoryPK.getCategoryId());
	}
}
