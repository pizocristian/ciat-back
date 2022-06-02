package uniajc.edu.spep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uniajc.edu.spep.exception.ResourceNotFoundException;
import uniajc.edu.spep.model.ZonaPlagaModel;
import uniajc.edu.spep.repository.ZonaPlagaRepository;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ZonaPlagaController {

    @Autowired
    ZonaPlagaRepository zonaRepository;



    @GetMapping("/zonaplaga")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<ZonaPlagaModel> getAllZona() { return zonaRepository.todo();}

}
