package mx.edu.utez.ApiPrincipios.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CedeDTO {
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotBlank(message = "El municipio es obligatorio")
    private String municipio;
}
