package mx.edu.utez.ApiPrincipios.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

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
    @Pattern(regexp = "G|M|P", message = "El tamaño debe ser G, M o P")
    private String tamano;

    public String getClaveAlmacen() {
        return claveAlmacen;
    }

    public void setClaveAlmacen(String claveAlmacen) {
        this.claveAlmacen = claveAlmacen;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(Double precioRenta) {
        this.precioRenta = precioRenta;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
}
