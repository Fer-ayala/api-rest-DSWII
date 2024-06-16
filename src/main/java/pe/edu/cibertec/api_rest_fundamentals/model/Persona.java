package pe.edu.cibertec.api_rest_fundamentals.model;

import lombok.Data;

@Data
public class Persona {
    int id;
    private String nombre;
    private String apellido;
    private int edad;
}
