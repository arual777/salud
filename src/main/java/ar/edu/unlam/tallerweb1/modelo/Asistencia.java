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
    private String descripcion;
    private Boolean camaAdentro;
    private Double tarifa;

    @OneToOne
    public Tipo_Turno idTurno;

    @OneToOne
    public Tipo_Asistencia idFrecuencia;

    @OneToOne
    public Zona zona;

    @ManyToOne
    @JoinColumn(updatable = false) //ponemos esto para evitar que se actualice a nulo cuando se actualiza una asistencia
    public Usuario usuario;

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getCamaAdentro() {
        return camaAdentro;
    }

    public void setCamaAdentro(Boolean camaAdentro) {
        this.camaAdentro = camaAdentro;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public Tipo_Asistencia getIdFrecuencia() {
        return idFrecuencia;
    }

    public void setIdFrecuencia(Tipo_Asistencia idFrecuencia) {
        this.idFrecuencia = idFrecuencia;
    }

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

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
