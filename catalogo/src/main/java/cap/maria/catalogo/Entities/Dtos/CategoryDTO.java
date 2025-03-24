package cap.maria.catalogo.Entities.Dtos;

import cap.maria.catalogo.Entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int categoryId;
    private String name;

    public static CategoryDTO from(Category category){
        return new CategoryDTO(category.getCategoryId(), category.getName());
    }

    public static Category from(CategoryDTO dto){
        return new Category(dto.getCategoryId(), dto.getName());
    }
}
