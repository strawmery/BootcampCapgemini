package cap.maria.catalogo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cap.maria.catalogo.Entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
