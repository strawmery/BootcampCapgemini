package cap.maria.demobatch.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String sexo;
    private String ip;
    
    public Persona(Long id, String nombre, String correo, String ip) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.ip = ip;
    }

    
}
