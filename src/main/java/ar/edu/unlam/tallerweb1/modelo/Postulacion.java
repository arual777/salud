package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Transactional
@Entity
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario profesional;

    @ManyToOne
    private Asistencia asistencia;

    private Boolean Aceptado;

    public Boolean getAceptado() {
        return Aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        Aceptado = aceptado;
    }

    public Usuario getProfesional() {
        return profesional;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfesional(Usuario profesional) {
        this.profesional = profesional;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }
}