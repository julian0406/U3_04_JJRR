package mx.edu.utez.ApiPrincipios.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.utez.ApiPrincipios.dto.CedeDTO;
import mx.edu.utez.ApiPrincipios.model.Cede;
import mx.edu.utez.ApiPrincipios.service.CedeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cedes")
@RequiredArgsConstructor
public class CedeController {
    private final CedeService cedeService;

    @PostMapping
    public ResponseEntity<Cede> crear(@Valid @RequestBody CedeDTO dto) {
        return ResponseEntity.ok(cedeService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<Cede>> obtenerTodos() {
        return ResponseEntity.ok(cedeService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cede> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cedeService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cede> actualizar(@PathVariable Long id, @Valid @RequestBody CedeDTO dto) {
        return ResponseEntity.ok(cedeService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cedeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
