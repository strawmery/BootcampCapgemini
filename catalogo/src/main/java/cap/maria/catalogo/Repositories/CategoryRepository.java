package cap.maria.catalogo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.maria.catalogo.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
