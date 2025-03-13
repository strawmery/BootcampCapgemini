package cap.maria.catalogo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;

import cap.maria.catalogo.Exceptions.InvalidDataException;

public interface DomainService<E, K>{
    List<E> getall();
    Optional <E> getOne(Integer id);
    
    E add(E item) throws DuplicateKeyException, InvalidDataException;

    E update(E item) throws DuplicateKeyException, InvalidDataException;

    void delete(E item) throws InvalidDataException;
    void deleteById(K id) throws InvalidDataException;

}
