package ni.com.ucem.apidemo.servicio;

import ni.com.ucem.apidemo.dominio.dto.Persona;
import ni.com.ucem.apidemo.repositorio.dao.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio {

    private final PersonaDao personaDao;

    @Autowired
    public PersonaServicio(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public Persona guardar(Persona persona) {
        return personaDao.guardar(persona);
    }

    public Persona obtenerPorId(int id) {
        return personaDao.obtenerPorId(id);
    }

    public List<Persona> obtenerTodo() {
        return personaDao.obtenerTodo();
    }

    public boolean eliminar(int id) {
        return personaDao.eliminar(id);
    }
}
