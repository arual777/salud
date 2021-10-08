package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Zona;

public class DatosAsistencia {

    private String nombre;
    private String descripcion;
    private Boolean camaAdentro;
    private Double tarifa;
    private long idTurno;
    private long idFrecuencia;
    private long zona;

    public long getZona() {
        return zona;
    }

    public void setZona(long zona) {
        this.zona = zona;
    }

    public long getIdTurno() {
        return idTurno;
    }

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

    public long getIdFrecuencia() {
        return idFrecuencia;
    }

    public void setIdFrecuencia(long idFrecuencia) {
        this.idFrecuencia = idFrecuencia;
    }


    public void setIdTurno(long idTurno) { this.idTurno = idTurno; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
