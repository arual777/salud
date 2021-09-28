package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
@Transactional
@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    @OneToOne(cascade = CascadeType.ALL)
    public Tipo_Turno idTurno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   public Tipo_Turno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Tipo_Turno idTurno) {
        this.idTurno = idTurno;
    }



}
