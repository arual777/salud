package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Java6Assertions.assertThat;


import java.util.List;

public class RepositorioPostulacionTest extends SpringTest {
    @Autowired

    private RepositorioPostulacion repositorioPostulacion;
    private Postulacion nuevaPostulacion = new Postulacion();

    @Test
    @Rollback
    @Transactional
    public void queSePuedaGuardarUnaPostulacion(){
        givenGuardoUnaNuevaAsistencia(nuevaPostulacion);
        List<Postulacion> postulaciones = whenBuscoUnaPostulacion(nuevaPostulacion);
        thenLaPostulacionSeGuarda(postulaciones, 1);
    }

    private void givenGuardoUnaNuevaAsistencia(Postulacion nuevaPostulacion) {
        repositorioPostulacion.guardar(nuevaPostulacion);
    }

    private List <Postulacion> whenBuscoUnaPostulacion(Postulacion nuevaPostulacion) {
        return repositorioPostulacion.buscarPostulacionesPorId(nuevaPostulacion.getId());
    }

    private void thenLaPostulacionSeGuarda(List<Postulacion> postulaciones, int postulacionesTotales) {
        assertThat(postulaciones).hasSize(postulacionesTotales);
    }


}
