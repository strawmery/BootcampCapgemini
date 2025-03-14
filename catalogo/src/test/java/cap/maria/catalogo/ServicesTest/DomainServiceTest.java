package cap.maria.catalogo.ServicesTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Services.DomainService;

@ExtendWith(MockitoExtension.class)
public class DomainServiceTest {

    @Mock
    private DomainService<Actor, Integer> domainService;

    private Actor actor;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        actor = new Actor(1, "jane", "doe");
    }

    @Test
    void testGetAll(){
        when(domainService.getall()).thenReturn(Arrays.asList(actor));

        List<Actor> actors = domainService.getall();

        assertFalse(actors.isEmpty());
        assertEquals(1, actors.size());
        assertEquals("jane", actors.get(0).getFirstName());
    }

    @Test
    void testGetOne(){
        when(domainService.getOne(1)).thenReturn(Optional.of(actor));

        Optional<Actor> foundActor = domainService.getOne(1);

        assertTrue(foundActor.isPresent());
        assertEquals("jane", foundActor.get().getFirstName());
    }

    @Test 
    void testAdd() throws Exception{
        when(domainService.add(actor)).thenReturn(actor);

        Actor addedActor = domainService.add(actor);

        assertNotNull(addedActor);
        assertEquals("jane", addedActor.getFirstName());
    }

    @Test
    void testUpdate() throws Exception{
        when(domainService.update(actor)).thenReturn(actor);

        Actor updatedActor = domainService.update(actor);

        assertNotNull(updatedActor);
        assertEquals("jane", updatedActor.getFirstName());
    }

    @Test
    void testDeleteById() throws Exception{
        doNothing().when(domainService).deleteById(1);

        assertDoesNotThrow(() -> domainService.deleteById(1));
        verify(domainService, times(1)).deleteById(1);
    }

}
