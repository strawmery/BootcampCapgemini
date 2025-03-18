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
import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.FilmRepository;
import cap.maria.catalogo.ServicesImpl.FilmServiceImpl;



public class FilmServiceImplTest {

    @Mock
    private FilmRepository repo;

    @InjectMocks
    private FilmServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        Film film1 = new Film();
        film1.setFilmId(1);
        film1.setTitle("Inception");

        Film film2 = new Film();
        film2.setFilmId(2);
        film2.setTitle("Titanic");

        List<Film> films = Arrays.asList(film1, film2);
        when(repo.findAll()).thenReturn(films);

        List<Film> result = service.getall();
        assertEquals(2, result.size());
        assertEquals("Inception", result.get(0).getTitle());
        assertEquals("Titanic", result.get(1).getTitle());
    }

    @Test
    void testGetOne() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");

        when(repo.findById(1)).thenReturn(Optional.of(film));

        Optional<Film> result = service.getOne(1);
        assertEquals(true, result.isPresent());
        assertEquals("Inception", result.get().getTitle());
    }

    @Test
    void testAdd() throws DuplicateKeyException, InvalidDataException {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");
        film.setReleaseYear((short) 2010);

        when(repo.existsById(1)).thenReturn(false);
        when(repo.save(film)).thenReturn(film);

        Film result = service.add(film);
        assertEquals("Inception", result.getTitle());
    }

    @Test
    void testAddDuplicateKeyException() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");
        film.setReleaseYear((short) 2010);

        when(repo.existsById(1)).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> {
            service.add(film);
        });
    }

    @Test
    void testAddInvalidDataException() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle(null);
        film.setReleaseYear(null);

        assertThrows(InvalidDataException.class, () -> {
            service.add(film);
        });
    }

    @Test
    void testUpdate() throws DuplicateKeyException, InvalidDataException {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");
        film.setReleaseYear((short) 2010);

        when(repo.existsById(1)).thenReturn(true);
        when(repo.save(film)).thenReturn(film);

        Film result = service.update(film);
        assertEquals("Inception", result.getTitle());
    }

    @Test
    void testUpdateDuplicateKeyException() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");
        film.setReleaseYear((short) 2010);

        when(repo.existsById(1)).thenReturn(false);

        assertThrows(DuplicateKeyException.class, () -> {
            service.update(film);
        });
    }

    @Test
    void testUpdateInvalidDataException() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle(null);
        film.setReleaseYear(null);

        assertThrows(InvalidDataException.class, () -> {
            service.update(film);
        });
    }

    @Test
    void testDelete() throws InvalidDataException {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");

        when(repo.existsById(1)).thenReturn(true);
        doNothing().when(repo).delete(film);

        service.delete(film);
        verify(repo, times(1)).delete(film);
    }

    @Test
    void testDeleteInvalidDataException() {
        Film film = new Film();
        film.setFilmId(1);
        film.setTitle("Inception");

        when(repo.existsById(1)).thenReturn(false);

        assertThrows(InvalidDataException.class, () -> {
            service.delete(film);
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