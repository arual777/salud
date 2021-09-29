package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioAsistenciaTest {

    private static final String NAME = "CuidadoPorNoche";
    private RepositorioAsistencia repositorioAsistencia = mock(RepositorioAsistencia.class);
    private ServicioAsistencia servicioAsistencia = new ServicioAsistenciaImpl(repositorioAsistencia);

    @Test
    public void deberíaPoderAgregarUnServicioInexistente(){
        givenNoExisteUnServicio(NAME);
        Asistencia creada = whenCreoUnServicio(NAME);
        thenLaCreacionEsExitosa(creada);
    }

    private void givenNoExisteUnServicio(String name) {
        when(repositorioAsistencia.buscar(name)).thenReturn(null);
    }

    private Asistencia whenCreoUnServicio(String name) {
        return servicioAsistencia.crearServicio(NAME);
    }
    private void thenLaCreacionEsExitosa(Asistencia creada){
        assertThat(creada).isNotNull();
        assertThat(creada.getNombre()).isEqualTo(NAME);
        verify(repositorioAsistencia, times(1)).guardar(any());
    }

    @Test
    public void SiBuscoUnServicioInexistenteDaError(){

        givenNoExisteUnServicio(NAME);
        whenBuscoUnServicioQueNoExiste();
        thenElServicioNoSeEncuentraYLanzaUnaExcepcion();
    }

    private void thenElServicioNoSeEncuentraYLanzaUnaExcepcion() {
    }

    private void whenBuscoUnServicioQueNoExiste() {
    }




}


