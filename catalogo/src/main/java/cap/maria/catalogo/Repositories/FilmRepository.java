package cap.maria.catalogo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.maria.catalogo.Entities.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    List<Film> findByTitleContainingIgnoreCase(String title);

    List<Film> findByFilmActors_Actor_FirstNameContainingIgnoreCaseOrFilmActors_Actor_LastNameContainingIgnoreCase(String firstName, String lastName);

    List<Film> findByFilmCategories_Category_NameIgnoreCase(String category);
    
    List<Film> findByLanguage_NameIgnoreCase(String language);
}
