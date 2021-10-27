package ar.edu.unlam.tallerweb1.controladores;

public class DatosPostulacion {

    private long idAsistencia;
    private long idUsuario;
    private long idPostulacion;
    public DatosPostulacion(long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public DatosPostulacion(){}

    public long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdPostulacion() { return idPostulacion; }

    public void setIdPostulacion(long idPostulacion) { this.idPostulacion = idPostulacion; }
}
