package pe.edu.cibertec.api_rest_fundamentals.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_rest_fundamentals.model.Persona;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements  IPersonaService {

    @Override
    public boolean buscarPersona(String nombre) {
        List<Persona> personaList= new ArrayList<>();
        Persona objPersona = new Persona();
        objPersona.setId(1);
        objPersona.setNombre("Luis");
        objPersona.setApellido("Ayala");
        objPersona.setEdad(27);
        personaList.add(objPersona);

        objPersona = new Persona();
        objPersona.setId(2);
        objPersona.setNombre("Mario");
        objPersona.setApellido("Acosta");
        objPersona.setEdad(35);
        personaList.add(objPersona);

        return personaList.stream().anyMatch(obj -> obj.getNombre().equals(nombre));
    }
}
