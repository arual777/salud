package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.servicios.ServicioService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ControladorServicioTest {

    private ServicioService servicioService = mock(ServicioService.class);
    private ControladorServicio controladorServicio = new ControladorServicio(servicioService);
    private final static DatosServicio SERVICIO = new DatosServicio("Cuidado Por Noche", "Consiste en la asistencia por noche", "consultar");

    @Test
    public void puedoRegistrarUnServicioConNombre(){
       givenNoExisteunServicio(SERVICIO);
        ModelAndView mav = whenCreoUnServicio(SERVICIO);
        thenLaCreacionEsExitosa(mav);
    }


    private void givenNoExisteunServicio(DatosServicio datos)
    {
    }

    private ModelAndView whenCreoUnServicio(DatosServicio datos)
    {
        return controladorServicio.crearServicio(datos);
    }

    private void thenLaCreacionEsExitosa(ModelAndView mav) {
        assertThat(mav.getModel().get("datos")).isEqualTo(SERVICIO);
    }

    @Test
    public void verificarSiHayServiciosDisponibles(){


    }


   // private void thenMeLoTrae() {}

   // private void whenBuscoUnServicio() {

        //return controladorServicio.buscarServicio();
    //}

    //private void givenHayUnServicioDisponible(Servicio nuevo) {

    //}


    @Test
    public void siBuscoLosServiciosMeLosTraeTodos(){
    }
}
