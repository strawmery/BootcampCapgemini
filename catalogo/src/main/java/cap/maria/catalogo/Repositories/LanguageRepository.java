package cap.maria.catalogo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cap.maria.catalogo.Entities.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
