package uniajc.edu.spep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uniajc.edu.spep.exception.ResourceNotFoundException;
import uniajc.edu.spep.model.UserModel;
import uniajc.edu.spep.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<UserModel> getAllUser() { return userRepository.findAll();}

    @PostMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserModel createUser(@Valid @RequestBody UserModel userModel) {
        return userRepository.save(userModel);
    }

    @GetMapping("/user/{id_user}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserModel getUserById(@PathVariable(value = "id_user") Long id_user) {
        return userRepository.findById(id_user)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id_user", id_user));
    }

    @PutMapping("/user/{id_user}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserModel updateUser(@PathVariable(value = "id_user") Long id_user,
                              @Valid @RequestBody UserModel userDetails) {

        UserModel userModel = userRepository.findById(id_user)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id_user", id_user));

        userModel.setRol(userDetails.getRol());
        userModel.setCorreo(userDetails.getCorreo());
        userModel.setPass(userDetails.getPass());

        UserModel updatedUser = userRepository.save(userModel);
        return updatedUser;
    }

    @DeleteMapping("/user/{id_user}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteRol(@PathVariable(value = "id_user") Long id_user) {
        UserModel updatedUser = userRepository.findById(id_user)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id_user", id_user));

        userRepository.delete(updatedUser);

        return ResponseEntity.ok().build();
    }
}
