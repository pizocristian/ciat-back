package uniajc.edu.spep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uniajc.edu.spep.model.ZonaModel;
import uniajc.edu.spep.model.ZonaPlagaModel;

import java.util.List;

@Repository
public interface ZonaPlagaRepository extends JpaRepository<ZonaPlagaModel, Long> {

    @Query(nativeQuery = true ,value = "select * from tb_plaga, tb_zona where tb_zona.id_plaga = tb_plaga.id_plaga")
    List <ZonaPlagaModel>  todo();

}
