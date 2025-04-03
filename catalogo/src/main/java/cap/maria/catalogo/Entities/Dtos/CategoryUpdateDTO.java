package cap.maria.catalogo.Entities.Dtos;

import cap.maria.catalogo.Entities.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDTO {
    @NotNull(message = "el id de la categoria no puede ser vacio")
    private Integer id;

    private String name;

    public static CategoryUpdateDTO from(Category category){
        return new CategoryUpdateDTO(category.getCategoryId(), category.getName());
    }

    public static Category from(CategoryUpdateDTO dto){
        return new Category(dto.getId(), dto.getName());
    }
}
