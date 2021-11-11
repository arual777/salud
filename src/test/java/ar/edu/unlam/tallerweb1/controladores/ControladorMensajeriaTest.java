package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMensajeria;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.ui.ModelMap;
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
    private final static DatosMensajeria DATOS_MENSAJERIA = new DatosMensajeria("hola", 1l, 1l);
    private final static Usuario usuarioCliente = new Usuario(1L);
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

    @Test
    public void queUnClientePuedaVerLasPreguntas() throws Exception {

        dadoQueExisteUnaPregunta(DATOS_MENSAJERIA);
        ModelAndView mav = cuandoUnClienteConsultaElBuzon(usuarioCliente);
        entoncesLasVe(mav);
    }
    private void dadoQueExisteUnaPregunta(DatosMensajeria datos) throws Exception {
        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

        controladorMensajeria.preguntar(httpServletRequestMock, datos);
    }

    private ModelAndView cuandoUnClienteConsultaElBuzon(Usuario usuarioCliente) {

        ModelMap model = new ModelMap();
        List<Mensaje> preguntas = servicioMensajeria.buscarPreguntasPorUsuario(usuarioCliente.getId());

        model.put("preguntas", preguntas);
        return new ModelAndView("buzon", model);
    }

    private void entoncesLasVe(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("buzon");
    }

    @Test
    public void queUnCLientePuedaResponderUnaPregunta() throws Exception {
        dadoQueExisteUnaPregunta(DATOS_MENSAJERIA);
        ModelAndView mav = cuandoUnClienteResponde(DATOS_MENSAJERIA);
        entoncesMeRedirigeALaVista(mav);
    }

    private void entoncesMeRedirigeALaVista(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/buzon");
    }

    private ModelAndView cuandoUnClienteResponde(DatosMensajeria datos) {
        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

        return controladorMensajeria.responder(httpServletRequestMock, datos);

    }

}
