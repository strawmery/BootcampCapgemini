package cap.maria.catalogo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;

import cap.maria.catalogo.Entities.Actor;
import cap.maria.catalogo.Exceptions.InvalidDataException;
import cap.maria.catalogo.Repositories.ActorRepository;

public class ActorServiceImpl implements ActorService {

    private ActorRepository repo;

    public void setRepo(ActorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Actor> getall() {
        return repo.findAll();
    }

    @Override
    public Optional<Actor> getOne(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Actor add(Actor item) throws DuplicateKeyException, InvalidDataException {
        if(item.getFirstName() == null || item.getLastName() == null) {
            throw new InvalidDataException();
        }if (repo.existsById(item.getActorId())) {
            throw new DuplicateKeyException("Actor already exists");
        } else {
            return repo.save(item);
        }
    }

    @Override
    public Actor update(Actor item) throws DuplicateKeyException, InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Actor item) throws InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteById(Integer id) throws InvalidDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
