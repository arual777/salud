package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class ReseniaAProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer calificacion;

    @Column
    private String comentario;

    @OneToOne
    public Usuario idUsuarioCliente;

    @OneToOne
    public Usuario idUsuarioProfesional;



    public void setId(Long id) {
        this.id = id;
    }

    //@Id
    public Long getId() {
        return id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(Usuario idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public Usuario getIdUsuarioProfesional() {
        return idUsuarioProfesional;
    }

    public void setIdUsuarioProfesional(Usuario idUsuarioProfesional) {
        this.idUsuarioProfesional = idUsuarioProfesional;
    }
}
