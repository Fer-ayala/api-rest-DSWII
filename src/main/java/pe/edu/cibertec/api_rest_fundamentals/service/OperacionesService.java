package pe.edu.cibertec.api_rest_fundamentals.service;

import org.springframework.stereotype.Service;

@Service
public class OperacionesService implements IOperacionesService{
    @Override
    public boolean validarNumeroEsPrimo(int numero) {

        if(numero <= 1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(numero);i++){
            if(numero%i==0) return false;
        }
        return true;
    }

    @Override
    public double elevarNumeroAlExponente(int numero, int exponente) {
        return Math.pow(numero,exponente);
    }
}
