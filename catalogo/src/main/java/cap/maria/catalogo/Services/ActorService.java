package cap.maria.catalogo.Services;

import cap.maria.catalogo.Entities.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActorService extends DomainService<Actor, Integer>{

    Page<Actor> getAll(Pageable pageable);

}
