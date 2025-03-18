package cap.maria.catalogo.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;

import cap.maria.catalogo.Entities.Film;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.FilmRepository;
import cap.maria.catalogo.Services.FilmService;

public class FilmServiceImpl implements FilmService{

    private FilmRepository repo;

    public void setRepo(FilmRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Film> getall() {
        return repo.findAll();
    }

    @Override
    public Optional<Film> getOne(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Film add(Film item) throws DuplicateKeyException, InvalidDataException {
        if(item.getTitle() == null || item.getReleaseYear() == null) {
            throw new InvalidDataException();
        }if (repo.existsById(item.getFilmId())) {
            throw new DuplicateKeyException("Film already exists");
        } else {
            return repo.save(item);
        }
    }

    @Override
    public Film update(Film item) throws DuplicateKeyException, InvalidDataException {
        if(item.getTitle() == null || item.getReleaseYear() == null) {
            throw new InvalidDataException();
        }if (!repo.existsById(item.getFilmId())) {
            throw new DuplicateKeyException("Film does not exist");
        } else {
            return repo.save(item);
        }
    }

    @Override
    public void delete(Film item) throws InvalidDataException {
        if(!repo.existsById(item.getFilmId())){
            throw new InvalidDataException("Film does not exist");
        }else{
            repo.delete(item);
        }
    }

    @Override
    public void deleteById(Integer id) throws InvalidDataException {
        if(!repo.existsById(id)){
            throw new InvalidDataException("Film does not exist");
        }else{
            repo.deleteById(id);
        }
    }

}
