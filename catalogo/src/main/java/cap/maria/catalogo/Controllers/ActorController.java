package cap.maria.catalogo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.ServicesImpl.ActorServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ActorController {

    private ActorServiceImpl service;

    public ActorController(ActorServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/actors/v1")
    public List<Actor> getAllActors() {

        return service.getall();
        
    }

    @GetMapping("/actors/v1/{id}")
    public Optional<Actor> getActorById(@RequestParam Integer id) {

        return service.getOne(id);
        
    }
}
