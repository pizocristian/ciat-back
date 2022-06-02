package uniajc.edu.spep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.edu.spep.model.RolModel;


@Repository
public interface RolRepository extends JpaRepository<RolModel, Long> {

}
