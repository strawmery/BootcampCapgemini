package cap.maria.catalogo.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cap.maria.catalogo.Entities.Language;

public interface LanguageService extends DomainService<Language, Integer>{

        Page<Language> getAll(Pageable pageable);

}
