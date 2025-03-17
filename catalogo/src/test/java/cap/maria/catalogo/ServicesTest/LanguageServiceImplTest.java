package cap.maria.catalogo.ServicesTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;

import cap.maria.catalogo.Entities.Language;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.LanguageRepository;
import cap.maria.catalogo.Services.LanguageServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LanguageServiceImplTest {

    @Mock
    private LanguageRepository repo;

    @InjectMocks
    private LanguageServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Language> languages = Arrays.asList(new Language(), new Language());
        when(repo.findAll()).thenReturn(languages);

        List<Language> result = service.getall();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetOne() {
        Language language = new Language();
        when(repo.findById(1)).thenReturn(Optional.of(language));

        Optional<Language> result = service.getOne(1);
        assertTrue(result.isPresent());
    }

    @Test
    public void testAdd() throws DuplicateKeyException, InvalidDataException {
        Language language = new Language();
        language.setName("English");
        when(repo.existsById(language.getLanguageId())).thenReturn(false);
        when(repo.save(language)).thenReturn(language);

        Language result = service.add(language);
        assertNotNull(result);
    }

    @Test
    public void testAddThrowsInvalidDataException() {
        Language language = new Language();
        assertThrows(InvalidDataException.class, () -> service.add(language));
    }

    @Test
    public void testAddThrowsDuplicateKeyException() {
        Language language = new Language();
        language.setName("English");
        when(repo.existsById(language.getLanguageId())).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> service.add(language));
    }

    @Test
    public void testUpdate() throws DuplicateKeyException, InvalidDataException {
        Language language = new Language();
        language.setName("English");
        when(repo.existsById(language.getLanguageId())).thenReturn(true);
        when(repo.save(language)).thenReturn(language);

        Language result = service.update(language);
        assertNotNull(result);
    }

    @Test
    public void testUpdateThrowsInvalidDataException() {
        Language language = new Language();
        assertThrows(InvalidDataException.class, () -> service.update(language));
    }

    @Test
    public void testUpdateThrowsDuplicateKeyException() {
        Language language = new Language();
        language.setName("English");
        when(repo.existsById(language.getLanguageId())).thenReturn(false);

        assertThrows(DuplicateKeyException.class, () -> service.update(language));
    }

    @Test
    public void testDelete() throws InvalidDataException {
        Language language = new Language();
        when(repo.existsById(language.getLanguageId())).thenReturn(true);

        service.delete(language);
        verify(repo, times(1)).delete(language);
    }

    @Test
    public void testDeleteThrowsInvalidDataException() {
        Language language = new Language();
        when(repo.existsById(language.getLanguageId())).thenReturn(false);

        assertThrows(InvalidDataException.class, () -> service.delete(language));
    }

    @Test
    public void testDeleteById() throws InvalidDataException {
        when(repo.existsById(1)).thenReturn(true);

        service.deleteById(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteByIdThrowsInvalidDataException() {
        when(repo.existsById(1)).thenReturn(false);

        assertThrows(InvalidDataException.class, () -> service.deleteById(1));
    }
}
