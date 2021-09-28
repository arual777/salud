package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ControladorAsistenciaTest {

    private ServicioAsistencia servicioAsistencia = mock(ServicioAsistencia.class);
    private ControladorAsistencias controladorAsistencias = new ControladorAsistencias(servicioAsistencia);
    private final static DatosAsistencia DATOS_ASISTENCIA = new DatosAsistencia("Cuidado Por Noche", "Consiste en la asistencia por noche");

    @Test
    public void puedoRegistrarUnServicioConNombre(){
        givenNoExisteunServicio(DATOS_ASISTENCIA);
        ModelAndView mav = whenCreoUnServicio(DATOS_ASISTENCIA);
        thenLaCreacionEsExitosa(mav);
    }


    private void givenNoExisteunServicio(DatosAsistencia datos)
    {
    }

    private ModelAndView whenCreoUnServicio(DatosAsistencia datos)
    {
        return controladorAsistencias.crearServicio(datos);
    }

    private void thenLaCreacionEsExitosa(ModelAndView mav) {
        assertThat(mav.getModel().get("datos")).isEqualTo(DATOS_ASISTENCIA);
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


