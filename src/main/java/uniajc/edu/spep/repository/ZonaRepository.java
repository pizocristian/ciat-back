package uniajc.edu.spep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uniajc.edu.spep.model.ZonaModel;
import uniajc.edu.spep.model.ZonaPlagaModel;
import java.util.List;

@Repository
public interface ZonaRepository extends JpaRepository<ZonaModel, Long> {

}
