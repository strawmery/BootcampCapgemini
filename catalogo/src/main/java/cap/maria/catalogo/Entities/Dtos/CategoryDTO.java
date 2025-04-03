package cap.maria.catalogo.Entities.Dtos;

import cap.maria.catalogo.Entities.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @NotNull(message = "el nombre de la categoria no puede ser vacio")
    private String name;

    public static CategoryDTO from(Category category){
        return new CategoryDTO(category.getName());
    }

    public static Category from(CategoryDTO dto){
        return new Category(dto.getName());
    }
}
