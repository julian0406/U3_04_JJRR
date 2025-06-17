package mx.edu.utez.ApiPrincipios.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.utez.ApiPrincipios.dto.AlmacenDTO;
import mx.edu.utez.ApiPrincipios.model.Almacen;
import mx.edu.utez.ApiPrincipios.service.AlmacenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
@RequiredArgsConstructor
public class AlmacenController {
    private final AlmacenService almacenService;

    @PostMapping
    public ResponseEntity<Almacen> crear(@Valid @RequestBody AlmacenDTO dto) {
        return ResponseEntity.ok(almacenService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<Almacen>> obtenerTodos() {
        return ResponseEntity.ok(almacenService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(almacenService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> actualizar(@PathVariable Long id, @Valid @RequestBody AlmacenDTO dto) {
        return ResponseEntity.ok(almacenService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        almacenService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
