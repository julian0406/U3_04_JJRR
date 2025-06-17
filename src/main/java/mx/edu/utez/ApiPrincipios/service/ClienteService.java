package mx.edu.utez.ApiPrincipios.service;

import mx.edu.utez.ApiPrincipios.dto.ClienteDTO;
import mx.edu.utez.ApiPrincipios.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crear(ClienteDTO dto);
    List<Cliente> obtenerTodos();
    Cliente obtenerPorId(Long id);
    Cliente actualizar(Long id, ClienteDTO dto);
    void eliminar(Long id);
}
