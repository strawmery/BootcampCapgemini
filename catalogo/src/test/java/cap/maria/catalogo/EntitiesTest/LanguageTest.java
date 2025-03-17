package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Entities.Language;

public class LanguageTest {

	@Test
	void testDefaultConstructor() {
		Language language = new Language();
		assertNotNull(language);
	}

	@Test
	void testSettersAndGetters() {
		Language language = new Language();
		language.setLanguageId(1);
		language.setName("English");
		language.setLastUpdate(new Timestamp(System.currentTimeMillis()));

		assertEquals(1, language.getLanguageId());
		assertEquals("English", language.getName());
		assertNotNull(language.getLastUpdate());
	}

	@Test
	void testAddFilm() {
		Language language = new Language();
		Film film = new Film();
		film.setFilmId(1);
		film.setTitle("Inception");

		List<Film> films = new ArrayList<>();
		films.add(film);
		language.setFilms(films);

		language.addFilm(film);

		assertEquals(1, language.getFilms().size());
		assertEquals(film, language.getFilms().get(0));
	}

	@Test
	void testRemoveFilm() {
		Language language = new Language();
		Film film = new Film();
		film.setFilmId(1);
		film.setTitle("Inception");

		List<Film> films = new ArrayList<>();
		films.add(film);
		language.setFilms(films);

		language.removeFilm(film);

		assertTrue(language.getFilms().isEmpty());
	}

	@Test
	void testAddFilmsVO() {
		Language language = new Language();
		Film film = new Film();
		film.setFilmId(1);
		film.setTitle("Inception");

		List<Film> filmsVO = new ArrayList<>();
		filmsVO.add(film);
		language.setFilmsVO(filmsVO);

		language.addFilmsVO(film);

		assertEquals(1, language.getFilmsVO().size());
		assertEquals(film, language.getFilmsVO().get(0));
	}

	@Test
	void testRemoveFilmsVO() {
		Language language = new Language();
		Film film = new Film();
		film.setFilmId(1);
		film.setTitle("Inception");

		List<Film> filmsVO = new ArrayList<>();
		filmsVO.add(film);
		language.setFilmsVO(filmsVO);

		language.removeFilmsVO(film);

		assertTrue(language.getFilmsVO().isEmpty());
	}
}
