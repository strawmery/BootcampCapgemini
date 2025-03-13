package cap.maria.catalogo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.maria.catalogo.Entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
