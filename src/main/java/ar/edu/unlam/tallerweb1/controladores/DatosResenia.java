package ar.edu.unlam.tallerweb1.controladores;

public class DatosResenia {

    private long id;
    private Integer calificacion;
    private String comentario;
    private long idUsuarioCliente;
    private long idUsuarioProfesional;

    public DatosResenia(){}

    public DatosResenia(Integer calificacion, String comentario, long idUsuarioCliente, long idUsuarioProfesional){
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.idUsuarioCliente = idUsuarioCliente;
        this.idUsuarioProfesional = idUsuarioProfesional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(long idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public long getIdUsuarioProfesional() {
        return idUsuarioProfesional;
    }

    public void setIdUsuarioProfesional(long idUsuarioProfesional) {
        this.idUsuarioProfesional = idUsuarioProfesional;
    }
}
