package cap.maria.catalogo.Controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Entities.Dtos.FilmDTO;
import cap.maria.catalogo.Exceptions.BadRequestException;
import cap.maria.catalogo.Exceptions.DuplicateKeyException;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Exceptions.NotFoundException;
import cap.maria.catalogo.ServicesImpl.FilmServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/film/v1")
public class FilmController {

    private final FilmServiceImpl srv;

    public FilmController(FilmServiceImpl srv){
        this.srv = srv;
    }

    @GetMapping
    @Operation(summary = "obtienes todos los idiomas")
    public List<Film> getAllFilms() {

        return srv.getall();
        
    }

    @GetMapping("{id}")
    @Operation(summary = "obtienes idioma por id")
    public FilmDTO getFilmById(@RequestParam Integer id) {

        return FilmDTO.from(srv.getOne(id).get()); 
        
    }

    @PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id,@RequestBody Film item, WebRequest request) throws BadRequestException, NotFoundException, InvalidDataException {
		if (item.getFilmId() != id) {
			throw new BadRequestException("El id del idioma no coincide con el recurso a modificar");
		}
		srv.update(item);
	}

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Entity created")
    @Operation(description = "Create a new entity")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create( @RequestBody Film item) throws BadRequestException, DuplicateKeyException, InvalidDataException {
        
        var newItem = srv.add(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newItem.getFilmId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws InvalidDataException{
        srv.deleteById(id);
    }

    @GetMapping(path = {"page"})
    @Operation(summary = "obtiene todos los idiomas paginados")
    public Page<Film> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "actorId") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return srv.getAll(pageable);
    }

}
