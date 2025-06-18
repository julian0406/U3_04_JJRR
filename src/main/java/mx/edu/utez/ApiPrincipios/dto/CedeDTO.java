package mx.edu.utez.ApiPrincipios.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
public class CedeDTO {
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotBlank(message = "El municipio es obligatorio")
    private String municipio;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
