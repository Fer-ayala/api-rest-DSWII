package pe.edu.cibertec.api_rest_fundamentals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EjemploController {

    @GetMapping("/saludo")
    public String saludo(){
      return "!!Hola mundo";
    };
}
