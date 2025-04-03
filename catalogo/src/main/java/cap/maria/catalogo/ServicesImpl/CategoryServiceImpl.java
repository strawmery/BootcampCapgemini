package cap.maria.catalogo.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cap.maria.catalogo.Entities.Category;
import cap.maria.catalogo.Exceptions.DuplicateKeyException;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Exceptions.NotFoundException;
import cap.maria.catalogo.Repositories.CategoryRepository;
import cap.maria.catalogo.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

     private CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Category> getall() {
        return repo.findAll();
    }

    @Override
    public Optional<Category> getOne(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Category add(Category item) throws InvalidDataException {
        System.out.println("Nombre de la categoría recibido: " + item.getName());

        if(item.getName() == null) {
            throw new InvalidDataException();
        } else {
            return repo.save(item);
        }
    }

    @Override
    public Category update(Category item) throws InvalidDataException, NotFoundException{
        Optional<Category> existingCategoryOpt = repo.findById(item.getCategoryId());
        if (!existingCategoryOpt.isPresent()) {
            throw new NotFoundException("Categoría no encontrada");
        }

        Category existingCategory = existingCategoryOpt.get();
        
        if (!existingCategory.getName().equals(item.getName()) && repo.existsByName(item.getName())) {
            throw new InvalidDataException("Ya existe una categoría con el mismo nombre");
        }

        if (item.getName() == null || item.getName().trim().isEmpty()) {
            throw new InvalidDataException("El nombre de la categoría no puede estar vacío");
        }

        existingCategory.setName(item.getName());

        return repo.save(existingCategory);
    }

    @Override
    public void delete(Category item) throws InvalidDataException {
        if(!repo.existsById(item.getCategoryId())){
            throw new InvalidDataException("Category does not exist");
        }else{
            repo.delete(item);
        }
    }

    @Override
    public void deleteById(Integer id) throws InvalidDataException {
        if(!repo.existsById(id)){
            throw new InvalidDataException("Category does not exist");
        }else{
            repo.deleteById(id);
        }
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
