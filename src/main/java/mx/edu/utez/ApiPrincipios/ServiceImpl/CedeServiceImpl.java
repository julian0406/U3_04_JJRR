package mx.edu.utez.ApiPrincipios.ServiceImpl;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.ApiPrincipios.Repository.CedeRepository;
import mx.edu.utez.ApiPrincipios.dto.CedeDTO;
import mx.edu.utez.ApiPrincipios.model.Cede;
import mx.edu.utez.ApiPrincipios.service.CedeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
//@RequiredArgsConstructor
public class CedeServiceImpl implements CedeService {
    private final CedeRepository cedeRepository;

    public CedeServiceImpl(CedeRepository cedeRepository){
        this.cedeRepository = cedeRepository;
    }

    @Override
    public Cede crear(CedeDTO dto) {
        Cede cede = new Cede();
        cede.setEstado(dto.getEstado());
        cede.setMunicipio(dto.getMunicipio());

        // Generar clave dinámica: C[id]-[ddMMyyyy]-[4 dígitos aleatorios]
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String random = String.format("%04d", new Random().nextInt(10000));
        cede.setClaveCede("C-PENDIENTE-" + fecha + "-" + random); // id real después de guardar

        Cede saved = cedeRepository.save(cede);
        saved.setClaveCede("C" + saved.getId() + "-" + fecha + "-" + random);
        return cedeRepository.save(saved);
    }

    @Override
    public List<Cede> obtenerTodos() {
        return cedeRepository.findAll();
    }

    @Override
    public Cede obtenerPorId(Long id) {
        return cedeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cede no encontrada"));
    }

    @Override
    public Cede actualizar(Long id, CedeDTO dto) {
        Cede cede = obtenerPorId(id);
        cede.setEstado(dto.getEstado());
        cede.setMunicipio(dto.getMunicipio());
        return cedeRepository.save(cede);
    }

    @Override
    public void eliminar(Long id) {
        cedeRepository.deleteById(id);
    }
}
