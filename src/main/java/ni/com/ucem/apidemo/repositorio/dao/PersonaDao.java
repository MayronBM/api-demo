package ni.com.ucem.apidemo.repositorio.dao;

import ni.com.ucem.apidemo.dominio.dto.Persona;

import java.util.List;

public interface PersonaDao {
    Persona guardar(Persona persona);

    boolean eliminar(int id);

    Persona obtenerPorId(int id);

    List<Persona> obtenerTodo();
}
