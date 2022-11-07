package ni.com.ucem.apidemo.repositorio.daoImplementacion;

import ni.com.ucem.apidemo.datosPruebas.PersonaDb;
import ni.com.ucem.apidemo.dominio.dto.Persona;
import ni.com.ucem.apidemo.repositorio.dao.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaDaoImpl implements PersonaDao {

    private final PersonaDb personaDb;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonaDaoImpl(PersonaDb personaDb,
                          JdbcTemplate jdbcTemplate) {
        this.personaDb = personaDb;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Persona guardar(Persona persona) {
        int id = jdbcTemplate.update("" +
                        "INSERT INTO public.persona( " +
                        "\"primerNombre\", \"segundoNombre\", \"primerApellido\", \"segundoApellido\", \"cedula\") " +
                        "VALUES (?, ?, ?, ?, ?);", persona.getPrimerNombre(),
                persona.getSegundoNombre(),
                persona.getPrimerApellido(),
                persona.getSegundoApellido(),
                persona.getCedula());
//        personaDb.getPersonas().add(persona);
        return obtenerPorId(id);
    }

    @Override
    public boolean eliminar(int id) {
        if (personaDb.getPersonas().stream().anyMatch(persona -> persona.getId().equals(id))) {
            personaDb.getPersonas().removeIf(persona -> persona.getId().equals(id));
            return true;
        }
        return false;
    }

    @Override
    public Persona obtenerPorId(int id) {
        return jdbcTemplate
                .queryForObject("Select * from public.persona where id = ?"
                        , BeanPropertyRowMapper.newInstance(Persona.class)
                        , id);
//        return personaDb.getPersonas().stream().filter(persona -> persona.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<Persona> obtenerTodo() {
        return personaDb.getPersonas();
    }
}
