package cap.maria.catalogo.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Entities.Language;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.LanguageRepository;
import cap.maria.catalogo.Services.LanguageService;

public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository repo;

    public void setRepo(LanguageRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Language> getall() {
        return repo.findAll();
    }

    @Override
    public Optional<Language> getOne(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Language add(Language item) throws DuplicateKeyException, InvalidDataException {
        if(item.getName() == null) {
            throw new InvalidDataException();
        }if (repo.existsById(item.getLanguageId())) {
            throw new DuplicateKeyException("Language already exists");
        } else {
            return repo.save(item);
        }
    }

    @Override
    public Language update(Language item) throws DuplicateKeyException, InvalidDataException {
        if(item.getName() == null) {
            throw new InvalidDataException();
        }if (!repo.existsById(item.getLanguageId())) {
            throw new DuplicateKeyException("Language does not exist");
        } else {
            return repo.save(item);
        }
    }

    @Override
    public void delete(Language item) throws InvalidDataException {
        if(!repo.existsById(item.getLanguageId())){
            throw new InvalidDataException("Language does not exist");
        }else{
            repo.delete(item);
        }
    }

    @Override
    public void deleteById(Integer id) throws InvalidDataException {
        if(!repo.existsById(id)){
            throw new InvalidDataException("Language does not exist");
        }else{
            repo.deleteById(id);
        }
    }

    @Override
    public Page<Language> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
