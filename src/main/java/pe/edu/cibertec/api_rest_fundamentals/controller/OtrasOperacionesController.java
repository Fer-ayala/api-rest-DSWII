package pe.edu.cibertec.api_rest_fundamentals.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_fundamentals.model.GeneralRequest;
import pe.edu.cibertec.api_rest_fundamentals.model.GeneralResponse;
import pe.edu.cibertec.api_rest_fundamentals.service.PersonaService;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/otrasope")
public class OtrasOperacionesController {

    private PersonaService personaService;

    // para probarlo poner localhost:8055/api/v1/otrasope/persona/Luis
    // y en objeto para el body del POST:
    //{
    //	"name": "Luis",
    //    "apellido":"salvat",
    //    "edad": 50
    //}
    @PostMapping("/persona/{nombre}")
    public ResponseEntity<GeneralResponse> ejemploPost(
            @PathVariable String nombre,
            @RequestBody GeneralRequest generalRequest){
        String mensaje = "Persona no Encontrada";
        if(personaService.buscarPersona(nombre)){
            mensaje = "person encontrada";
        }
        GeneralResponse response = GeneralResponse.builder().mensaje(mensaje).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
