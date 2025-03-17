package cap.maria.catalogo.ServicesTest;

import static org.junit.jupiter.api.Assertions.*;
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
import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.ActorRepository;
import cap.maria.catalogo.Services.ActorServiceImpl;
public class ActorServiceImplTest {

    @Mock
    private ActorRepository repo;

    @InjectMocks
    private ActorServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Actor> actors = Arrays.asList(new Actor(), new Actor());
        when(repo.findAll()).thenReturn(actors);

        List<Actor> result = service.getall();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetOne() {
        Actor actor = new Actor();
        when(repo.findById(1)).thenReturn(Optional.of(actor));

        Optional<Actor> result = service.getOne(1);
        assertTrue(result.isPresent());
    }

    @Test
    public void testAdd() throws DuplicateKeyException, InvalidDataException {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Doe");
        when(repo.existsById(actor.getActorId())).thenReturn(false);
        when(repo.save(actor)).thenReturn(actor);

        Actor result = service.add(actor);
        assertNotNull(result);
    }

    @Test
    public void testAddThrowsInvalidDataException() {
        Actor actor = new Actor();
        assertThrows(InvalidDataException.class, () -> {
            service.add(actor);
        });
    }

    @Test
    public void testAddThrowsDuplicateKeyException() {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Doe");
        when(repo.existsById(actor.getActorId())).thenReturn(true);

        assertThrows(DuplicateKeyException.class, () -> {
            service.add(actor);
        });
    }

    @Test
    public void testUpdate() throws DuplicateKeyException, InvalidDataException {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Doe");
        when(repo.existsById(actor.getActorId())).thenReturn(true);
        when(repo.save(actor)).thenReturn(actor);

        Actor result = service.update(actor);
        assertNotNull(result);
    }

    @Test
    public void testUpdateThrowsInvalidDataException() {
        Actor actor = new Actor();
        assertThrows(InvalidDataException.class, () -> {
            service.update(actor);
        });
    }

    @Test
    public void testUpdateThrowsDuplicateKeyException() {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Doe");
        when(repo.existsById(actor.getActorId())).thenReturn(false);

        assertThrows(DuplicateKeyException.class, () -> {
            service.update(actor);
        });
    }

    @Test
    public void testDelete() throws InvalidDataException {
        Actor actor = new Actor();
        when(repo.existsById(actor.getActorId())).thenReturn(true);

        service.delete(actor);
        verify(repo, times(1)).delete(actor);
    }

    @Test
    public void testDeleteThrowsInvalidDataException() {
        Actor actor = new Actor();
        when(repo.existsById(actor.getActorId())).thenReturn(false);

        assertThrows(InvalidDataException.class, () -> {
            service.delete(actor);
        });
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

        assertThrows(InvalidDataException.class, () -> {
            service.deleteById(1);
        });
    }
}