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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cap.maria.catalogo.Entities.Category;
import cap.maria.catalogo.Entities.Dtos.CategoryDTO;
import cap.maria.catalogo.Exceptions.BadRequestException;
import cap.maria.catalogo.Exceptions.DuplicateKeyException;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Exceptions.NotFoundException;
import cap.maria.catalogo.ServicesImpl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category/v1")
public class CategoryController {

    private final CategoryServiceImpl srvc;

    public CategoryController(CategoryServiceImpl srvc){
        this.srvc = srvc;
    }

    @GetMapping
    @Operation(summary = "obtienes todos los actores")
    public List<Category> getAllCategories() {

        return srvc.getall();
        
    }

    @GetMapping("{id}")
    @Operation(summary = "obtienes actor por id")
    public Optional<Category> getCategoryById(@RequestParam Integer id) {

        return srvc.getOne(id);
        
    }

    @PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id, @Valid @RequestBody CategoryDTO item) throws BadRequestException, NotFoundException, InvalidDataException {
		if (item.getCategoryId() != id) {
			throw new BadRequestException("El id del actor no coincide con el recurso a modificar");
		}
		srvc.update(CategoryDTO.from(item));
	}

    @PostMapping
    @ApiResponse(responseCode = "201", description = "actor creado")
    public ResponseEntity<Object> create(@RequestBody CategoryDTO item) throws BadRequestException, DuplicateKeyException, InvalidDataException{
        var newItem = srvc.add(CategoryDTO.from(item));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newItem.getCategoryId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws InvalidDataException{
        srvc.deleteById(id);
    }

    @GetMapping(path = {"page"})
    @Operation(summary = "obtiene todos los actores paginados")
    public Page<Category> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "actorId") String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return srvc.getAll(pageable);
    }

}
