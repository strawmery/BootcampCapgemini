package cap.maria.proyecto.contracts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.maria.proyecto.core.Entities.Actor;

public interface ActorRepository extends JpaRepository <Actor, Integer>{

}
