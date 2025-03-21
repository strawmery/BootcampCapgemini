package cap.maria.catalogo.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cap.maria.catalogo.Entities.Category;

public interface CategoryService extends DomainService<Category, Integer>{

    Page<Category> getAll(Pageable pageable);
}
