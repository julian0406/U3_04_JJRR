package mx.edu.utez.ApiPrincipios.service;

import mx.edu.utez.ApiPrincipios.dto.CedeDTO;
import mx.edu.utez.ApiPrincipios.model.Cede;

import java.util.List;

public interface CedeService {
    Cede crear(CedeDTO dto);
    List<Cede> obtenerTodos();
    Cede obtenerPorId(Long id);
    Cede actualizar(Long id, CedeDTO dto);
    void eliminar(Long id);
}
