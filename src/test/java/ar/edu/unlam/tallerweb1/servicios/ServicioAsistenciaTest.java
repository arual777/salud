package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.mockito.Mockito.*;

public class ServicioAsistenciaTest {
    private static final String NOMBRESERVICIO = "CuidadoPorNoche";
    private RepositorioAsistencia repositorioAsistencia = mock(RepositorioAsistencia.class);
    private ServicioAsistencia servicioAsistencia = new ServicioAsistenciaImpl(repositorioAsistencia);

    @Test(expected = Exception.class)
    public void SiBuscoUnServicioInexistenteDaError() throws Exception {
        whenCreoUnServicio(NOMBRESERVICIO);
        servicioAsistencia.buscarAsistenciaPorId(3);
    }

    @Test
    @Transactional
    @Rollback
    public void SiBuscoUnServicioExistenteLoRetorna() throws Exception {
        when(repositorioAsistencia.buscarAsistenciaPorId(1)).thenReturn(new Asistencia());
        Assertions.assertThat(servicioAsistencia.buscarAsistenciaPorId(1)).isOfAnyClassIn(Asistencia.class);
    }

    private void thenLaCreacionEsExitosa(Asistencia creada){
        Assertions.assertThat(creada).isNotNull();
        Assertions.assertThat(creada.getNombre()).isEqualTo(NOMBRESERVICIO);
        verify(repositorioAsistencia, times(1)).guardar(any());
    }

    @Test
    public void debePoderAgregarUnServicio(){
        Asistencia creada = whenCreoUnServicio(NOMBRESERVICIO);
        thenLaCreacionEsExitosa(creada);
    }

    private Asistencia whenCreoUnServicio(String name) {
        return servicioAsistencia.crearServicio(name);
    }
}