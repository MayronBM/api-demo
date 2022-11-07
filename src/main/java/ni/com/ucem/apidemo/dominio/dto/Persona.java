package ni.com.ucem.apidemo.dominio.dto;

import lombok.Data;

@Data
public class Persona {

    private Integer id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;

}
