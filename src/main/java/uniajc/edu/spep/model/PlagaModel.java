package uniajc.edu.spep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "tb_plaga")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class PlagaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plaga;

    public Long getId_plaga() {
        return id_plaga;
    }

    public void setId_plaga(Long id_plaga) {
        this.id_plaga = id_plaga;
    }

    public String getNombre_plaga() {
        return nombre_plaga;
    }

    public void setNombre_plaga(String nombre_plaga) {
        this.nombre_plaga = nombre_plaga;
    }

    private String nombre_plaga;


}
