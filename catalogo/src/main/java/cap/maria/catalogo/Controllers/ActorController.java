package cap.maria.catalogo.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Entities.Dtos.ActorDTO;
import cap.maria.catalogo.Exceptions.BadRequestException;
import cap.maria.catalogo.Exceptions.DuplicateKeyException;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Exceptions.NotFoundException;
import cap.maria.catalogo.ServicesImpl.ActorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/actores/v1")
public class ActorController {

    private ActorServiceImpl service;

    public ActorController(ActorServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    @Operation(summary = "obtienes todos los actores")
    public List<Actor> getAllActors() {

        return service.getall();
        
    }

    @GetMapping("{id}")
    @Operation(summary = "obtienes actor por id")
    public ActorDTO getActorById(@RequestParam Integer id) {

        return ActorDTO.from(service.getOne(id).get()); 
        
    }

    @PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id,@RequestBody ActorDTO item, WebRequest request) throws BadRequestException, NotFoundException, InvalidDataException {
		if (item.getActorId() != id) {
			throw new BadRequestException("El id del actor no coincide con el recurso a modificar");
		}
		service.update(ActorDTO.from(item));
	}

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Entity created")
    @Operation(description = "Create a new entity")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create( @RequestBody ActorDTO item) throws BadRequestException, DuplicateKeyException, InvalidDataException {
        
        var newItem = service.add(ActorDTO.from(item));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newItem.getActorId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws InvalidDataException{
        service.deleteById(id);
    }

    @GetMapping(path = {"page"})
    @Operation(summary = "obtiene todos los actores paginados")
    public Page<Actor> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "actorId") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return service.getAll(pageable);
    }



}
