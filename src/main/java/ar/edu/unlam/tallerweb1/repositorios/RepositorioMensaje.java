package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RepositorioMensaje {
    void crearPregunta(Mensaje mensaje);
  Mensaje buscarMensajePorId(long idMensaje);
 // List <Mensaje> buscarMensajesPorId(Long id);
    List<Mensaje> buscarLosMensajesPorIdUsuario(Long idUsuario);
    void actualizar(Mensaje mensaje);
    List<Mensaje> buscarLosMensajesRespondidosPorIdUsuario(Long idUsuario);
}
