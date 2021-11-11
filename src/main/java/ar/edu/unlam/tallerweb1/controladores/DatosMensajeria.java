package ar.edu.unlam.tallerweb1.controladores;

public class DatosMensajeria {

    private String mensaje;
    private long idUsuario;
    private long idAsistencia;
    private long idMensaje;

    public DatosMensajeria(String mensaje, long idUsuario, long idAsistencia) {
        this.mensaje = mensaje;
        this.idUsuario = idUsuario;
        this.idAsistencia = idAsistencia;
    }

    public DatosMensajeria(){

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public long getIdMensaje() { return this.idMensaje; }

    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }


}
