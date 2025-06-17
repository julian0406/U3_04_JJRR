package mx.edu.utez.ApiPrincipios.ServiceImpl;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.ApiPrincipios.Repository.AlmacenRepository;
import mx.edu.utez.ApiPrincipios.dto.AlmacenDTO;
import mx.edu.utez.ApiPrincipios.model.Almacen;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AlmacenServiceImpl {
    private final AlmacenRepository almacenRepository;

    @Override
    public Almacen crear(AlmacenDTO dto) {
        Almacen almacen = new Almacen();
        almacen.setFechaRegistro(dto.getFechaRegistro());
        almacen.setPrecioVenta(dto.getPrecioVenta());
        almacen.setPrecioRenta(dto.getPrecioRenta());
        almacen.setTamaño(dto.getTamano());

        // Aquí puedes generar la clave usando la clave de la cede si está disponible
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String random = String.format("%04d", new Random().nextInt(10000));
        almacen.setClaveAlmacen("A-PENDIENTE-" + fecha + "-" + random);

        Almacen saved = almacenRepository.save(almacen);
        saved.setClaveAlmacen(saved.getClaveAlmacen().replace("PENDIENTE", String.valueOf(saved.getId())));
        return almacenRepository.save(saved);
    }

    @Override
    public List<Almacen> obtenerTodos() {
        return almacenRepository.findAll();
    }

    @Override
    public Almacen obtenerPorId(Long id) {
        return almacenRepository.findById(id).orElseThrow(() -> new RuntimeException("Almacén no encontrado"));
    }

    @Override
    public Almacen actualizar(Long id, AlmacenDTO dto) {
        Almacen almacen = obtenerPorId(id);
        almacen.setFechaRegistro(dto.getFechaRegistro());
        almacen.setPrecioVenta(dto.getPrecioVenta());
        almacen.setPrecioRenta(dto.getPrecioRenta());
        almacen.setTamaño(dto.getTamano());
        return almacenRepository.save(almacen);
    }

    @Override
    public void eliminar(Long id) {
        almacenRepository.deleteById(id);
    }
}
