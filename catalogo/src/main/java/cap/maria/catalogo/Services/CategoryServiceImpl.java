package cap.maria.catalogo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;

import cap.maria.catalogo.Entities.Category;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.CategoryRepository;

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
    public Category add(Category item) throws DuplicateKeyException, InvalidDataException {
        if(item.getName() == null) {
            throw new InvalidDataException();
        }if (repo.existsById(item.getCategoryId())) {
            throw new DuplicateKeyException("Category already exists");
        } else {
            return repo.save(item);
        }
    }

    @Override
    public Category update(Category item) throws DuplicateKeyException, InvalidDataException {
        if(item.getName() == null) {
            throw new InvalidDataException();
        }if (!repo.existsById(item.getCategoryId())) {
            throw new DuplicateKeyException("Category does not exist");
        } else {
            return repo.save(item);
        }
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

}
