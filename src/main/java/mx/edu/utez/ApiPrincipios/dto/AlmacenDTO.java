package mx.edu.utez.ApiPrincipios.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class AlmacenDTO {
    @NotBlank(message = "La clave del almacén no puede estar vacía")
    private String claveAlmacen;

    @PastOrPresent(message = "La fecha no puede ser futura")
    private Date fechaRegistro;

    @NotNull(message = "El precio de venta es obligatorio")
    @Positive(message = "El precio debe ser mayor a cero")
    private Double precioVenta;

    @NotNull(message = "El precio de renta es obligatorio")
    @PositiveOrZero(message = "El precio debe ser mayor o igual a cero")
    private Double precioRenta;

    @NotNull(message = "El tamaño es obligatorio")
    private Boolean tamano;
}
