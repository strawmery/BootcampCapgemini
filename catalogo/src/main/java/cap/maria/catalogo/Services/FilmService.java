package cap.maria.catalogo.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cap.maria.catalogo.Entities.Film;


public interface FilmService extends DomainService<Film, Integer>{

    Page<Film> getAll(Pageable pageable);

}
