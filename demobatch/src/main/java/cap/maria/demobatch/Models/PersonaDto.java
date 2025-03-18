package cap.maria.demobatch.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {

    private Long id;
    private String Nombre;
    private String Apellido;
    private String correo;
    private String sexo;
    private String ip;
    
}
