package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Entities.FilmActor;
import cap.maria.catalogo.Entities.FilmCategory;
import cap.maria.catalogo.Entities.Language;

public class FilmTest {

	private Film film;

	@BeforeEach
	public void setUp() {
		film = new Film();
	}

	@Test
	public void testGetAndSetFilmId() {
		film.setFilmId(1);
		assertEquals(1, film.getFilmId());
	}

	@Test
	public void testGetAndSetDescription() {
		film.setDescription("A great movie");
		assertEquals("A great movie", film.getDescription());
	}

	@Test
	public void testGetAndSetLastUpdate() {
		Date timestamp = new Date(System.currentTimeMillis());
		film.setLastUpdate(timestamp);
		assertEquals(timestamp, film.getLastUpdate());
	}

	@Test
	public void testGetAndSetLength() {
		film.setLength(120);
		assertEquals(120, film.getLength());
	}

	@Test
	public void testGetAndSetRating() {
		film.setRating("R");
		assertEquals("R", film.getRating());
	}

	@Test
	public void testGetAndSetReleaseYear() {
		film.setReleaseYear((short) 2021);
		assertEquals((short) 2021, film.getReleaseYear());
	}

	@Test
	public void testGetAndSetRentalDuration() {
		film.setRentalDuration((byte) 5);
		assertEquals((byte) 5, film.getRentalDuration());
	}

	@Test
	public void testGetAndSetRentalRate() {
		BigDecimal rentalRate = new BigDecimal("4.99");
		film.setRentalRate(rentalRate);
		assertEquals(rentalRate, film.getRentalRate());
	}

	@Test
	public void testGetAndSetReplacementCost() {
		BigDecimal replacementCost = new BigDecimal("19.99");
		film.setReplacementCost(replacementCost);
		assertEquals(replacementCost, film.getReplacementCost());
	}

	@Test
	public void testGetAndSetTitle() {
		film.setTitle("Inception");
		assertEquals("Inception", film.getTitle());
	}

	@Test
	public void testGetAndSetLanguage() {
		Language language = new Language();
		film.setLanguage(language);
		assertEquals(language, film.getLanguage());
	}

	@Test
	public void testGetAndSetLanguageVO() {
		Language languageVO = new Language();
		film.setLanguageVO(languageVO);
		assertEquals(languageVO, film.getLanguageVO());
	}

	@Test
	public void testGetAndSetFilmActors() {
		List<FilmActor> filmActors = new ArrayList<>();
		film.setFilmActors(filmActors);
		assertEquals(filmActors, film.getFilmActors());
	}

	@Test
	public void testAddFilmActor() {
		FilmActor filmActor = new FilmActor();
		film.setFilmActors(new ArrayList<>());
		film.addFilmActor(filmActor);
		assertTrue(film.getFilmActors().contains(filmActor));
		assertEquals(film, filmActor.getFilm());
	}

	@Test
	public void testRemoveFilmActor() {
		FilmActor filmActor = new FilmActor();
		film.setFilmActors(new ArrayList<>());
		film.addFilmActor(filmActor);
		film.removeFilmActor(filmActor);
		assertFalse(film.getFilmActors().contains(filmActor));
		assertNull(filmActor.getFilm());
	}

	@Test
	public void testGetAndSetFilmCategories() {
		List<FilmCategory> filmCategories = new ArrayList<>();
		film.setFilmCategories(filmCategories);
		assertEquals(filmCategories, film.getFilmCategories());
	}

	@Test
	public void testAddFilmCategory() {
		FilmCategory filmCategory = new FilmCategory();
		film.setFilmCategories(new ArrayList<>());
		film.addFilmCategory(filmCategory);
		assertTrue(film.getFilmCategories().contains(filmCategory));
		assertEquals(film, filmCategory.getFilm());
	}

	@Test
	public void testRemoveFilmCategory() {
		FilmCategory filmCategory = new FilmCategory();
		film.setFilmCategories(new ArrayList<>());
		film.addFilmCategory(filmCategory);
		film.removeFilmCategory(filmCategory);
		assertFalse(film.getFilmCategories().contains(filmCategory));
		assertNull(filmCategory.getFilm());
	}
}