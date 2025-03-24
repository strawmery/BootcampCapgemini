package cap.maria.catalogo.Entities.Dtos;

// import com.fasterxml.jackson.annotation.JsonProperty;

import cap.maria.catalogo.Entities.Actor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Actor", description = "Datos del actor")
public class ActorDTO {
//	@JsonProperty("id")
	private Integer actorId;
	@Schema(description = "Nombre del actor", example = "Pepito", required = true, minLength = 2, maxLength = 45)
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 45)
	@Schema(description = "Apellidos del actor", example = "Grillo")
	private String lastName;
	
	public static ActorDTO from(Actor source) {
		return new ActorDTO(source.getActorId(), source.getFirstName(), source.getLastName());
	}
	
	public static Actor from(ActorDTO source) {
		return new Actor(source.getActorId() == null ? 0 : source.getActorId(), source.getFirstName(), source.getLastName());
	}
}
