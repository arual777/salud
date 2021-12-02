package ar.edu.unlam.tallerweb1.controladores;

public class DatosFiltro {

    private Long idZona;
    private Long idTurno;
    private Boolean camaAdentro;


    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public void setCamaAdentro(Boolean camaAdentro) { this.camaAdentro = camaAdentro; }

    public Boolean getCamaAdentro(){ return this.camaAdentro; }

}
