package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RepositorioMensajeTest extends SpringTest {

    @Autowired
    private RepositorioMensaje repositorioMensaje;

    @Before
    public void s(){
        session().clear();
    }



    @Test
    @Rollback
    @Transactional
    public void queSeGuardeUnaNuevaPregunta(){

         Mensaje nuevoMensaje = new Mensaje();

        dadoQueGuardoUnaPregunta(nuevoMensaje);
        Mensaje pregunta =cuandoBuscoLaPreguntaPorId(1L);
        entoncesLaEncuentro(pregunta);
    }

    private void entoncesLaEncuentro(Mensaje pregunta) {
        assertThat(pregunta).isNotNull();
    }

    private Mensaje  cuandoBuscoLaPreguntaPorId(long id) {

        return repositorioMensaje.buscarMensajePorId(id);

    }

    private void dadoQueGuardoUnaPregunta(Mensaje nuevoMensaje) {
        repositorioMensaje.crearPregunta(nuevoMensaje);
    }


    @Test
    @Rollback
    @Transactional
    public void QueSeObtenganLasPreguntasPorUsuario(){
        Usuario nuevoUsuario = new Usuario();
        Mensaje nuevoMensaje = new Mensaje();
        Asistencia nuevaAsistencia = new Asistencia();
        dadoQueGuardoUnaNuevaPregunta(nuevoUsuario, nuevoMensaje, nuevaAsistencia);
        List <Mensaje> preguntas = cuandoBuscoLasPreguntasPorUsuario(1);
        entoncesLaEncuentro(preguntas, 1);
    }

    private void dadoQueGuardoUnaNuevaPregunta(Usuario nuevoUsuario, Mensaje nuevoMensaje, Asistencia nuevaAsistencia) {

        session().save(nuevoUsuario);
        nuevoMensaje.setUsuario(nuevoUsuario);
        nuevoMensaje.setIdMensaje(1l);
        nuevoMensaje.setPregunta("donde estan");

        nuevaAsistencia.setUsuario(nuevoUsuario);
        session().save(nuevaAsistencia);
        nuevoMensaje.setAsistencia(nuevaAsistencia);
        repositorioMensaje.crearPregunta(nuevoMensaje);
    }

    private void entoncesLaEncuentro(List<Mensaje> preguntas, int preguntasEsperadas) {
            assertThat(preguntas).hasSize(preguntasEsperadas);
    }

    private List<Mensaje> cuandoBuscoLasPreguntasPorUsuario(long idUsuario) {

        return repositorioMensaje.buscarLosMensajesPorIdUsuario(idUsuario);

    }
}
