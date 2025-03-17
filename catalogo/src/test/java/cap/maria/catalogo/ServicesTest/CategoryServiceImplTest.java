package cap.maria.catalogo.ServicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DuplicateKeyException;
import cap.maria.catalogo.Entities.Category;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.CategoryRepository;
import cap.maria.catalogo.Services.CategoryServiceImpl;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository repo;

    @InjectMocks
    private CategoryServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        Category category1 = new Category();
        category1.setCategoryId(1);
        category1.setName("Action");

        Category category2 = new Category();
        category2.setCategoryId(2);
        category2.setName("Drama");

        List<Category> categories = Arrays.asList(category1, category2);
        when(repo.findAll()).thenReturn(categories);

        List<Category> result = service.getall();
        assertEquals(2, result.size());
        assertEquals("Action", result.get(0).getName());
        assertEquals("Drama", result.get(1).getName());
    }

    @Test
    void testGetOne() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.findById(1)).thenReturn(Optional.of(category));

        Optional<Category> result = service.getOne(1);
        assertEquals(true, result.isPresent());
        assertEquals("Action", result.get().getName());
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.existsById(1)).thenReturn(false);
        when(repo.save(category)).thenReturn(category);

        Category result = service.add(category);
        assertEquals("Action", result.getName());
    }

    @Test
    void testAddDuplicateKeyException() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.existsById(1)).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> {
            service.add(category);
        });
    }

    @Test
    void testAddInvalidDataException() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName(null);

        assertThrows(InvalidDataException.class, () -> {
            service.add(category);
        });
    }

    @Test
    void testUpdate() throws DuplicateKeyException, InvalidDataException {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.existsById(1)).thenReturn(true);
        when(repo.save(category)).thenReturn(category);

        Category result = service.update(category);
        assertEquals("Action", result.getName());
    }

    @Test
    void testUpdateDuplicateKeyException() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.existsById(1)).thenReturn(false);

        assertThrows(DuplicateKeyException.class, () -> {
            service.update(category);
        });
    }

    @Test
    void testUpdateInvalidDataException() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName(null);

        assertThrows(InvalidDataException.class, () -> {
            service.update(category);
        });
    }

    @Test
    void testDelete() throws InvalidDataException {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.existsById(1)).thenReturn(true);
        doNothing().when(repo).delete(category);

        service.delete(category);
        verify(repo, times(1)).delete(category);
    }

    @Test
    void testDeleteInvalidDataException() {
        Category category = new Category();
        category.setCategoryId(1);
        category.setName("Action");

        when(repo.existsById(1)).thenReturn(false);

        assertThrows(InvalidDataException.class, () -> {
            service.delete(category);
        });
    }

    @Test
    void testDeleteById() throws InvalidDataException {
        when(repo.existsById(1)).thenReturn(true);
        doNothing().when(repo).deleteById(1);

        service.deleteById(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    void testDeleteByIdInvalidDataException() {
        when(repo.existsById(1)).thenReturn(false);

        assertThrows(InvalidDataException.class, () -> {
            service.deleteById(1);
        });
    }
}