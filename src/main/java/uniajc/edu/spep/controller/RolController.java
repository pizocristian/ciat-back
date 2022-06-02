package uniajc.edu.spep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uniajc.edu.spep.exception.ResourceNotFoundException;
import uniajc.edu.spep.model.RolModel;
import uniajc.edu.spep.repository.RolRepository;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    RolRepository rolRepository;

    @GetMapping("/rol")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<RolModel> getAllRol() { return rolRepository.findAll();}

    @PostMapping("/rol")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public RolModel createRol(@Valid @RequestBody RolModel rolModel) {
        return rolRepository.save(rolModel);
    }

    @GetMapping("/rol/{id_rol}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public RolModel getRolById(@PathVariable(value = "id_rol") Long id_rol) {
        return rolRepository.findById(id_rol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id_rol", id_rol));
    }

    @PutMapping("/rol/{id_rol}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public RolModel updateRol(@PathVariable(value = "id_rol") Long id_rol,
                                        @Valid @RequestBody RolModel rolDetails) {

        RolModel rolModel = rolRepository.findById(id_rol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id_rol", id_rol));

        rolModel.setNombre(rolDetails.getNombre());

        RolModel updatedRol = rolRepository.save(rolModel);
        return updatedRol;
    }

    @DeleteMapping("/rol/{id_rol}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteRol(@PathVariable(value = "id_rol") Long id_rol) {
        RolModel updatedRol = rolRepository.findById(id_rol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id_rol", id_rol));

        rolRepository.delete(updatedRol);

        return ResponseEntity.ok().build();
    }
}
