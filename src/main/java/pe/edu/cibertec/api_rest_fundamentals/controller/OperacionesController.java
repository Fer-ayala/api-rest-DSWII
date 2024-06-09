package pe.edu.cibertec.api_rest_fundamentals.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_fundamentals.service.IOperacionesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OperacionesController {

    //11:22 a.m hora de la anotacion del principio SOLID de segregación de interfaces mencionado
    //no se deben instanciar clases directamente sino interfaces a través de la notacion @ALlArgsConstructor
    //esto es otra manera de usar la notación @Autowired en el atributo debajo para inyectar la dependecia
    private IOperacionesService iOperacionesService;

    // Prueba en postman = localhost:8055/api/v1/esprimo/27
    @GetMapping("/esprimo/{numero}")
    public boolean validarNumeroPrimo(@PathVariable int numero){
        //Se usa la notación @PathVariable para indicar que el parámetro es una variable de ruta
        //@PathVariable se puede usar con un nombre de parámetro diferente, es decir:
        //@GetMapping("/esprimo/{numero}")
        //public boolean validarNumeroPrimo(@PathVariable("numero") int num){
        //se nota que numero y num son diferentes y por eso se añade despues de @PathVariable los
        //paréntesis ("numero") indicandole como se llama el parámetro de ruta y asociarlo con el parámetro
        //num
        //11:34 esuchar en la grabación sobre el principio solid
        return iOperacionesService.validarNumeroEsPrimo(numero);
    }

    // Prueba en postman = localhost:8055/api/v1/elevarexponente/3/2
    @GetMapping("/elevarexponente/{numero}/{exponente}")
    public double elevarAlExponente(@PathVariable int numero,@PathVariable int exponente){
        return iOperacionesService.elevarNumeroAlExponente(numero,exponente);
    };

    // Prueba en postman = localhost:8055/api/v1/primo?numero=11
    @GetMapping("/primo")
    public boolean ValidarPrimo(@RequestParam int numero, @RequestParam(required = false) boolean filtro){
        // El parámetro @RequestParam(required = false) boolean filtro es opcional debido a
        // que su propiedad required es 'false' por lo que en la ruta se puede definir así:
        // localhost:8055/api/v1/primo?numero=11 o así: localhost:8055/api/v1/primo?numero=11&filtro=true
        return iOperacionesService.validarNumeroEsPrimo(numero);
    }

    // Prueba en postman = localhost:8055/api/v1/elevar?num=5&exp=2
    @GetMapping("/elevar")
    public double elevarExponente(@RequestParam int num,@RequestParam(defaultValue = "2") int exp){
        // Se puede usar @RequestParam(defaultValue = "2") para definir un valor por defecto, de esta
        // manera se puede enviar la petición con solo un parámetro y el programa toma el valor por
        // defecto (localhost:8055/api/v1/elevar?num=11). Esto es opcional
        return iOperacionesService.elevarNumeroAlExponente(num,exp);
    }

    //@RequestParam tiene las opciones(defaultValue) y (required)
    //@PathVariable solo acepta (required), es decir, no acepta (defaultValue)

    // Se puede combinar el @RequestParam y @PathVariable respetando sus reglas
    // Prueba en Postman = localhost:8055/api/v1/datos/11?nombres=Luis&nombres=Angel
    @GetMapping("/datos/{num}")
    public String listaNombres(@PathVariable int num,@RequestParam List<String> nombres){
        return "Nombres: " + String.join(", ", nombres);
    }

}
