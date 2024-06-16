package pe.edu.cibertec.api_rest_fundamentals.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GeneralResponse {
    private String mensaje;
}
