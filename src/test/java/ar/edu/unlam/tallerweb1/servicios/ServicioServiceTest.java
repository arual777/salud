package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ServicioServiceTest {

    private static final String NAME = "CuidadoPorNoche";
    private RepositorioService repositorioService = mock(RepositorioService.class);
    private ServicioService servicioService = new ServicioServiceImpl(repositorioService);

    @Test
    public void deberíaPoderAgregarUnServicioInexistente(){
        givenNoExisteUnServicio(NAME);
        Servicio creado = whenCreoUnServicio(NAME);
        thenLaCreacionEsExitosa(creado);
    }

    private void givenNoExisteUnServicio(String name) {
        when(repositorioService.buscar(name)).thenReturn(null);
    }

    private Servicio whenCreoUnServicio(String name) {
        return servicioService.crearServicio(NAME);
    }
    private void thenLaCreacionEsExitosa(Servicio creado){
        assertThat(creado).isNotNull();
        assertThat(creado.getName()).isEqualTo(NAME);
        verify(repositorioService, times(1)).guardar(any());
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
