package ni.com.ucem.apidemo.web.controlador;

import ni.com.ucem.apidemo.dominio.dto.Persona;
import ni.com.ucem.apidemo.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    private PersonaServicio personaServicio;

    @Autowired
    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping("/todos")
    public List<Persona> obtenerTodo() {
        return personaServicio.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Persona obtenerPorId(@PathVariable("id") int id) {
        return personaServicio.obtenerPorId(id);
    }

    @PostMapping("/guardar")
    public Persona guardar(@RequestBody Persona persona) {
        return personaServicio.guardar(persona);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable("id") int id) {
        return personaServicio.eliminar(id);
    }
}
