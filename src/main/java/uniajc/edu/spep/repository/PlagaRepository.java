package uniajc.edu.spep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.edu.spep.model.PlagaModel;


@Repository
public interface PlagaRepository extends JpaRepository<PlagaModel, Long> {

}
