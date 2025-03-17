package cap.maria.catalogo.EntitiesTest;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.sql.Timestamp;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.Category;
import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Entities.FilmCategory;
import cap.maria.catalogo.Entities.FilmCategoryPK;

public class FilmCategoryTest {

	@Test
	void createFilmCategory() {
		FilmCategoryPK id = new FilmCategoryPK();
		id.setCategoryId(1);
		id.setFilmId(2);

		Category category = new Category();
		category.setCategoryId(1);
		category.setName("Action");

		Film film = new Film();
		film.setFilmId(2);
		film.setTitle("Inception");

		FilmCategory filmCategory = new FilmCategory();
		filmCategory.setId(id);
		filmCategory.setCategory(category);
		filmCategory.setFilm(film);
		filmCategory.setLastUpdate(new Timestamp(System.currentTimeMillis()));

		assertNotNull(filmCategory);
		assertAll("Constructor",
			() -> assertEquals(id, filmCategory.getId(), "id"),
			() -> assertEquals(category, filmCategory.getCategory(), "category"),
			() -> assertEquals(film, filmCategory.getFilm(), "film"),
			() -> assertNotNull(filmCategory.getLastUpdate(), "lastUpdate"));
	}

	@Test
	void testSettersAndGetters() {
		FilmCategoryPK id = new FilmCategoryPK();
		id.setCategoryId(1);
		id.setFilmId(2);

		Category category = new Category();
		category.setCategoryId(1);
		category.setName("Action");

		Film film = new Film();
		film.setFilmId(2);
		film.setTitle("Inception");

		FilmCategory filmCategory = new FilmCategory();
		filmCategory.setId(id);
		filmCategory.setCategory(category);
		filmCategory.setFilm(film);
		filmCategory.setLastUpdate(new Timestamp(System.currentTimeMillis()));

		assertEquals(id, filmCategory.getId());
		assertEquals(category, filmCategory.getCategory());
		assertEquals(film, filmCategory.getFilm());
		assertNotNull(filmCategory.getLastUpdate());
	}

	@Test
	void testNotEquals() {
		FilmCategoryPK id1 = new FilmCategoryPK();
		id1.setCategoryId(1);
		id1.setFilmId(2);

		FilmCategoryPK id2 = new FilmCategoryPK();
		id2.setCategoryId(2);
		id2.setFilmId(3);

		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setName("Action");

		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setName("Drama");

		Film film1 = new Film();
		film1.setFilmId(2);
		film1.setTitle("Inception");

		Film film2 = new Film();
		film2.setFilmId(3);
		film2.setTitle("Titanic");

		FilmCategory filmCategory1 = new FilmCategory();
		filmCategory1.setId(id1);
		filmCategory1.setCategory(category1);
		filmCategory1.setFilm(film1);
		filmCategory1.setLastUpdate(new Timestamp(System.currentTimeMillis()));

		FilmCategory filmCategory2 = new FilmCategory();
		filmCategory2.setId(id2);
		filmCategory2.setCategory(category2);
		filmCategory2.setFilm(film2);
		filmCategory2.setLastUpdate(new Timestamp(System.currentTimeMillis()));

		assertNotEquals(filmCategory1, filmCategory2);
	}
}