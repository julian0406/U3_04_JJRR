package mx.edu.utez.ApiPrincipios.Repository;

import mx.edu.utez.ApiPrincipios.model.Almacen;
import mx.edu.utez.ApiPrincipios.model.Cede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Long> {
}
