package uniajc.edu.spep.repository;

import uniajc.edu.spep.model.ERole;
import uniajc.edu.spep.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
