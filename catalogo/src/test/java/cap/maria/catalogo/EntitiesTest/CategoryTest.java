package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cap.maria.catalogo.Entities.Category;
import cap.maria.catalogo.Entities.FilmCategory;


public class CategoryTest {

	private Category category;

	@BeforeEach
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetAndSetCategoryId() {
		category.setCategoryId(1);
		assertEquals(1, category.getCategoryId());
	}

	@Test
	public void testGetAndSetLastUpdate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		category.setLastUpdate(timestamp);
		assertEquals(timestamp, category.getLastUpdate());
	}

	@Test
	public void testGetAndSetName() {
		category.setName("Action");
		assertEquals("Action", category.getName());
	}

	@Test
	public void testGetAndSetFilmCategories() {
		List<FilmCategory> filmCategories = new ArrayList<>();
		category.setFilmCategories(filmCategories);
		assertEquals(filmCategories, category.getFilmCategories());
	}

	@Test
	public void testAddFilmCategory() {
		FilmCategory filmCategory = new FilmCategory();
		category.setFilmCategories(new ArrayList<>());
		category.addFilmCategory(filmCategory);
		assertTrue(category.getFilmCategories().contains(filmCategory));
		assertEquals(category, filmCategory.getCategory());
	}

	@Test
	public void testRemoveFilmCategory() {
		FilmCategory filmCategory = new FilmCategory();
		category.setFilmCategories(new ArrayList<>());
		category.addFilmCategory(filmCategory);
		category.removeFilmCategory(filmCategory);
		assertFalse(category.getFilmCategories().contains(filmCategory));
		assertNull(filmCategory.getCategory());
	}
}