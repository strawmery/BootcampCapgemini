package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.FilmText;

public class FilmTextTest {

	@Test
	void testDefaultConstructor() {
		FilmText filmText = new FilmText();
		assertNotNull(filmText);
	}

	@Test
	void testSettersAndGetters() {
		FilmText filmText = new FilmText();
		filmText.setFilmId((short) 1);
		filmText.setDescription("A great movie");
		filmText.setTitle("Inception");

		assertEquals(1, filmText.getFilmId());
		assertEquals("A great movie", filmText.getDescription());
		assertEquals("Inception", filmText.getTitle());
	}

	@Test
	void testParameterizedConstructor() {
		FilmText filmText = new FilmText();
		filmText.setFilmId((short) 1);
		filmText.setDescription("A great movie");
		filmText.setTitle("Inception");

		assertEquals(1, filmText.getFilmId());
		assertEquals("A great movie", filmText.getDescription());
		assertEquals("Inception", filmText.getTitle());
	}
}