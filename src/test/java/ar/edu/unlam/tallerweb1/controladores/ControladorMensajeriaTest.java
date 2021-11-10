package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioMensajeria;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorMensajeriaTest {


    private ServicioMensajeria servicioMensajeria = mock(ServicioMensajeria.class);
    private ControladorMensajeria controladorMensajeria = new ControladorMensajeria(servicioMensajeria);
    private HttpServletRequest httpServletRequestMock =  mock(HttpServletRequest.class);
    private HttpSession httpSessionMock = mock(HttpSession.class);
    private DatosMensajeria datosMensajeria = new DatosMensajeria();

    @Test
    public void queUnProfesionalLogueadoPuedaEnviarUnaPreguntaAlCliente () throws Exception{

        DadoQueHayUnProfesionalLogueado();
        ModelAndView mav = CuandoEnviaUnaPregunta(datosMensajeria);
        EntoncesMeLlevaALaVistaDeMensajeria(mav);
    }

    private void EntoncesMeLlevaALaVistaDeMensajeria(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("empleos-publicados");}

    private ModelAndView CuandoEnviaUnaPregunta(DatosMensajeria datosMensajeria) throws Exception {

        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

        return controladorMensajeria.preguntar(httpServletRequestMock, datosMensajeria);
    }

    private void DadoQueHayUnProfesionalLogueado() {

    }

   /** @Test
    public void queUnClientePuedaVerLasPreguntas() throws Exception {
        dadoQueExisteUnaPregunta();
        ModelAndView mav = cuandoUnClienteConsultaElBuzon();
        entoncesLasVe(mav);
    }

    private void entoncesLasVe(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buzon");
    }

    private ModelAndView cuandoUnClienteConsultaElBuzon() {
        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);
        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");
        return controladorMensajeria.verPreguntas(httpServletRequestMock);
    }

    private void dadoQueExisteUnaPregunta() throws Exception {
        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

       controladorMensajeria.preguntar(httpServletRequestMock, datosMensajeria);
    }
**/

}
