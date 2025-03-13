package cap.maria.catalogo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.maria.catalogo.Entities.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
