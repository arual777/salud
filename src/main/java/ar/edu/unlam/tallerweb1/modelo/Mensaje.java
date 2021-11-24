package ar.edu.unlam.tallerweb1.modelo;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;

@Transactional
@Entity
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensaje;

    private String pregunta;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Asistencia asistencia;

    private String respuesta;

    private Boolean respuestaLeida = false;

    public void setIdMensaje(Long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Boolean getRespuestaLeida() {
        return respuestaLeida;
    }

    public void setRespuestaLeida(Boolean respuestaLeida) {
        this.respuestaLeida = respuestaLeida;
    }

    public long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }


    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}