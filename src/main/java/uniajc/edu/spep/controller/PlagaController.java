package uniajc.edu.spep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uniajc.edu.spep.exception.ResourceNotFoundException;
import uniajc.edu.spep.model.PlagaModel;
import uniajc.edu.spep.repository.PlagaRepository;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PlagaController {

    @Autowired
    PlagaRepository plagaRepository;


    @GetMapping("/plaga")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<PlagaModel> getAllPlaga() { return plagaRepository.findAll();}


    @PostMapping("/plaga")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public PlagaModel plagaModel(@Valid @RequestBody PlagaModel plagaModel) {
        return plagaRepository.save(plagaModel);
    }


    @GetMapping("/plaga/{id_plaga}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public PlagaModel getPlagaById(@PathVariable(value = "id_plaga") Long id_plaga) {
        return plagaRepository.findById(id_plaga)
                .orElseThrow(() -> new ResourceNotFoundException("Plaga", "id_plaga", id_plaga));
    }


    @PutMapping("/plaga/{id_plaga}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public PlagaModel updatePlaga(@PathVariable(value = "id_plaga") Long id_plaga,
                           @Valid @RequestBody PlagaModel plagaDetails) {

        PlagaModel plagaModel = plagaRepository.findById(id_plaga)
                .orElseThrow(() -> new ResourceNotFoundException("Plaga", "id_plaga", id_plaga));

        plagaModel.setNombre_plaga(plagaDetails.getNombre_plaga());

        PlagaModel updatedPlaga = plagaRepository.save(plagaModel);
        return updatedPlaga;
    }

    
    @DeleteMapping("/plaga/{id_plaga}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deletePlaga(@PathVariable(value = "id_plaga") Long id_plaga) {
        PlagaModel plagaModel = plagaRepository.findById(id_plaga)
                .orElseThrow(() -> new ResourceNotFoundException("Plaga", "id_plaga", id_plaga));

        plagaRepository.delete(plagaModel);

        return ResponseEntity.ok().build();
    }
}
