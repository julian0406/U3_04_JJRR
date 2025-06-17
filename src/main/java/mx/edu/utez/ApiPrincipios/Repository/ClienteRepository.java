package mx.edu.utez.ApiPrincipios.Repository;

import mx.edu.utez.ApiPrincipios.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
