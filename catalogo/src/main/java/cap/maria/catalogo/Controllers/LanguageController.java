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

import cap.maria.catalogo.Entities.Language;
import cap.maria.catalogo.Exceptions.BadRequestException;
import cap.maria.catalogo.Exceptions.DuplicateKeyException;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Exceptions.NotFoundException;
import cap.maria.catalogo.ServicesImpl.LanguageServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/languages/v1")
public class LanguageController {

    private final LanguageServiceImpl srv;

    public LanguageController(LanguageServiceImpl srv){
        this.srv = srv;
    }

    
    @GetMapping
    @Operation(summary = "obtienes todos los idiomas")
    public List<Language> getAllLanguages() {

        return srv.getall();
        
    }

    @GetMapping("{id}")
    @Operation(summary = "obtienes idioma por id")
    public Optional<Language> getLanguageById(@RequestParam Integer id) {

        return srv.getOne(id); 
        
    }

    @PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id,@RequestBody Language item, WebRequest request) throws BadRequestException, NotFoundException, InvalidDataException {
		if (item.getLanguageId() != id) {
			throw new BadRequestException("El id del idioma no coincide con el recurso a modificar");
		}
		srv.update(item);
	}

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Entity created")
    @Operation(description = "Create a new entity")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create( @RequestBody Language item) throws BadRequestException, DuplicateKeyException, InvalidDataException {
        
        var newItem = srv.add(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newItem.getLanguageId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws InvalidDataException{
        srv.deleteById(id);
    }

    @GetMapping(path = {"page"})
    @Operation(summary = "obtiene todos los idiomas paginados")
    public Page<Language> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "actorId") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return srv.getAll(pageable);
    }


}
