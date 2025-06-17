package mx.edu.utez.ApiPrincipios.service;

import mx.edu.utez.ApiPrincipios.dto.AlmacenDTO;
import mx.edu.utez.ApiPrincipios.model.Almacen;

import java.util.List;

public interface AlmacenService {
    Almacen crear(AlmacenDTO dto);
    List<Almacen> obtenerTodos();
    Almacen obtenerPorId(Long id);
    Almacen actualizar(Long id, AlmacenDTO dto);
    void eliminar(Long id);
}
