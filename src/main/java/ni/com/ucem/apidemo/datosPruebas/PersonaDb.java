package ni.com.ucem.apidemo.datosPruebas;

import lombok.Data;
import ni.com.ucem.apidemo.dominio.dto.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class PersonaDb {
    List<Persona> personas;

    public PersonaDb() {
        personas = new ArrayList<>();
        Persona persona = new Persona();
        persona.setId(1);
        persona.setPrimerNombre("Mayron");
        persona.setSegundoNombre("Josue");
        persona.setPrimerApellido("Barboza");
        persona.setSegundoApellido("Mendoza");

        personas.add(persona);

        persona = new Persona();
        persona.setId(2);
        persona.setPrimerNombre("Marling");
        persona.setSegundoNombre("Guissel");
        persona.setPrimerApellido("García");
        persona.setSegundoApellido("Vallecillo");

        personas.add(persona);
    }
}
