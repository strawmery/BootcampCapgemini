package cap.maria.catalogo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.FilmRepository;

@Service
public class FilmService implements DomainService{

    private FilmRepository repo;

    public FilmService(FilmRepository repo) {
        this.repo = repo;
    }

    @Override
    public List getall() {
        return repo.findAll();
    }

    @Override
    public Optional<Film> getOne(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Object add(Object item) throws DuplicateKeyException, InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Object update(Object item) throws DuplicateKeyException, InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Object item) throws InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteById(Object id) throws InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
