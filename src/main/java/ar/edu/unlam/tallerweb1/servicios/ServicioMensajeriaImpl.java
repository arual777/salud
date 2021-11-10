package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosMensajeria;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMensaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioMensajeImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioMensajeria")
@Transactional
public class ServicioMensajeriaImpl implements ServicioMensajeria{

    private RepositorioMensaje repositorioMensaje;
    private RepositorioAsistencia repositorioAsistencia;
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioMensajeriaImpl(RepositorioMensaje repositorioMensaje, RepositorioAsistencia repositorioAsistencia, RepositorioUsuario repositorioUsuario){
    this.repositorioMensaje = repositorioMensaje;
    this.repositorioAsistencia = repositorioAsistencia;
    this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public void crearPregunta(DatosMensajeria datosMensajeria) {

        Mensaje mensaje = new Mensaje();
        Usuario usuario = repositorioUsuario.buscarUsuario(datosMensajeria.getIdUsuario());
        Asistencia asistencia = repositorioAsistencia.buscarAsistenciaPorId(datosMensajeria.getIdAsistencia());
        mensaje.setPregunta(datosMensajeria.getMensaje());
        mensaje.setAsistencia(asistencia);
        mensaje.setUsuario(usuario);
        repositorioMensaje.crearPregunta(mensaje);
    }


    @Override
    public List<Mensaje> buscarPreguntasPorUsuario(Long idUsuario) {
        return repositorioMensaje.buscarLosMensajesPorIdUsuario(idUsuario);
    }

    @Override
    public void responder(DatosMensajeria datosMensajeria) {
        Mensaje mensaje = repositorioMensaje.buscarMensajePorId(datosMensajeria.getIdMensaje());
        mensaje.setRespuesta(datosMensajeria.getMensaje());

        repositorioMensaje.actualizar(mensaje);
    }


}
