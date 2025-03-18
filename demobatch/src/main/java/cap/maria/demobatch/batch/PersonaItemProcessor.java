package cap.maria.demobatch.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import cap.maria.demobatch.Models.PersonaDto;
import cap.maria.demobatch.Models.Persona;
 
@Component
public class PersonaItemProcessor implements ItemProcessor<PersonaDto, Persona> {
    private static final Logger log = LoggerFactory.getLogger(PersonaItemProcessor.class);
    
    @Override
    public Persona process(PersonaDto item) throws Exception {
        if(item.getId() % 2 == 0 && "Male".equals(item.getSexo())) return null;
        Persona rslt = new Persona(item.getId(), item.getApellido(), item.getNombre(), item.getCorreo(),item.getSexo(), item.getIp());
        log.info("Procesando: " + item);
        return rslt;
    }
}