package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
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

    public Tipo_Turno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Tipo_Turno idTurno) {
        this.idTurno = idTurno;
    }



}
