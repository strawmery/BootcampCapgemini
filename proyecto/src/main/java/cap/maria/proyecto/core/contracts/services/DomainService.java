package cap.maria.proyecto.core.contracts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import cap.maria.proyecto.exception.DuplicateKeyException;
import cap.maria.proyecto.exception.InvalidDataException;

public interface DomainService<E, K> {

    List<E> getAll();
	
	Optional<E> getOne(K id);
	
	E add(E item) throws DuplicateKeyException, InvalidDataException;
	
	E modify(E item) throws NotFoundException, InvalidDataException;
	
	void delete(E item) throws InvalidDataException;
	void deleteById(K id);

}
