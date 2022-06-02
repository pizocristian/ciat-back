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
public class ZonaPlagaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zona;


    private String nombre_zona;

    private String nombre_plaga;
    private String nombre;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "tb_plaga",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private int cantidad_palmas;

    public Long getId_zona() {
        return id_zona;
    }

    public void setId_zona(Long id_zona) {
        this.id_zona = id_zona;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }

    public String getNombre_plaga() {
        return nombre_plaga;
    }

    public void setNombre_plaga(String nombre_plaga) {
        this.nombre_plaga = nombre_plaga;
    }

    public int getCantidad_palmas() {
        return cantidad_palmas;
    }

    public void setCantidad_palmas(int cantidad_palmas) {
        this.cantidad_palmas = cantidad_palmas;
    }

    public int getId_plaga() {
        return id_plaga;
    }

    public void setId_plaga(int id_plaga) {
        this.id_plaga = id_plaga;
    }

    private int id_plaga;



}
