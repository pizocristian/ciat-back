package uniajc.edu.spep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uniajc.edu.spep.exception.ResourceNotFoundException;
import uniajc.edu.spep.model.ZonaModel;
import uniajc.edu.spep.model.ZonaPlagaModel;
import uniajc.edu.spep.repository.ZonaRepository;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ZonaController {

    @Autowired
    ZonaRepository zonaRepository;



    @GetMapping("/zona")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ZonaModel> getAllZona() { return zonaRepository.findAll();}


    @PostMapping("/zona")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ZonaModel zonaModel(@Valid @RequestBody ZonaModel zonaModel) {
        return zonaRepository.save(zonaModel);
    }


    @GetMapping("/zona/{id_zona}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ZonaModel getZonaById(@PathVariable(value = "id_zona") Long id_zona) {
        return zonaRepository.findById(id_zona)
                .orElseThrow(() -> new ResourceNotFoundException("Zona", "id_zona", id_zona));
    }


    @PutMapping("/zona/{id_zona}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ZonaModel updateZona(@PathVariable(value = "id_zona") Long id_zona,
                           @Valid @RequestBody ZonaModel zonaDetails) {

        ZonaModel zonaModel = zonaRepository.findById(id_zona)
                .orElseThrow(() -> new ResourceNotFoundException("Zona", "id_zona", id_zona));

        zonaModel.setNombre_zona(zonaDetails.getNombre_zona());
        zonaModel.setCantidad_palmas(zonaDetails.getCantidad_palmas());
        zonaModel.setId_plaga(zonaDetails.getId_plaga());
        zonaModel.setNombre_plaga(zonaDetails.getNombre_plaga());

        ZonaModel updatedZona = zonaRepository.save(zonaModel);
        return updatedZona;
    }

    
    @DeleteMapping("/zona/{id_zona}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteZona(@PathVariable(value = "id_zona") Long id_zona) {
        ZonaModel zonaModelModel = zonaRepository.findById(id_zona)
                .orElseThrow(() -> new ResourceNotFoundException("Zona", "id_zona", id_zona));

        zonaRepository.delete(zonaModelModel);

        return ResponseEntity.ok().build();
    }
}
