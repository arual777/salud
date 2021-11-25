package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMensajeria;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorMensajeriaTest {


    private ServicioMensajeria servicioMensajeriaMock = mock(ServicioMensajeria.class);
    private ControladorMensajeria controladorMensajeria = new ControladorMensajeria(servicioMensajeriaMock);
    private HttpServletRequest httpServletRequestMock =  mock(HttpServletRequest.class);
    private HttpSession httpSessionMock = mock(HttpSession.class);
    private DatosMensajeria datosMensajeria = new DatosMensajeria();
    private final static DatosMensajeria DATOS_MENSAJERIA = new DatosMensajeria("hola", 1l, 1l);
    private final static Usuario usuarioCliente = new Usuario(1L);
    private final static Usuario usuarioProfesional = new Usuario(3l);
    private String mensaje = "hola";

   /** @Test
    public void queUnProfesionalLogueadoPuedaEnviarUnaPreguntaAlCliente () throws Exception{

        DadoQueHayUnProfesionalLogueado();

        ModelAndView mav = CuandoEnviaUnaPregunta(DATOS_MENSAJERIA);
        EntoncesMeLlevaALaVistaDeMensajeria(mav);
    }



    private void EntoncesMeLlevaALaVistaDeMensajeria(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("empleos-publicados");}

    private ModelAndView CuandoEnviaUnaPregunta(DatosMensajeria DATOS_MENSAJERIA) throws Exception {

        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

        when(this.httpSessionMock.getAttribute("rolID")).thenReturn("2");

        return controladorMensajeria.preguntar(httpServletRequestMock, datosMensajeria);
    }

    private void DadoQueHayUnProfesionalLogueado() {

    }
**/
    public void queUnClientePuedaVerLasPreguntas() throws Exception {
        dadoQueExisteUnaPregunta(DATOS_MENSAJERIA);
        ModelAndView mav = cuandoUnClienteConsultaElBuzon(usuarioCliente);
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

    private void dadoQueExisteUnaPregunta(DatosMensajeria datos) throws Exception {
        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

        controladorMensajeria.preguntar(httpServletRequestMock, datos);
    }

    private ModelAndView cuandoUnClienteConsultaElBuzon(Usuario usuarioCliente) {

        ModelMap model = new ModelMap();
        List<Mensaje> preguntas = servicioMensajeriaMock.buscarPreguntasPorUsuario(usuarioCliente.getId());

        model.put("preguntas", preguntas);
        return new ModelAndView("buzon", model);
    }

    /**@Test
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
**/
    @Test
    public void queUnProfesionalPuedaVerLasRespuestasDelCliente() throws Exception {
        dadoQueExisteUnaPreguntaConRespuesta();
        ModelAndView mav= cuandoUnProfesionalEntraASuMensajeria();
        entoncesMeLlevaALaVistaRespuestasYTieneUnNuevoCorreo(mav);
    }

    private void dadoQueExisteUnaPreguntaConRespuesta() {

        List<Mensaje> mensaje = new ArrayList<Mensaje>();
        Usuario profesional = new Usuario(1L);
        Asistencia asistencia = new Asistencia(1L);
        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setUsuario(profesional);
        mensajeNuevo.setAsistencia(asistencia);
        mensajeNuevo.setIdMensaje(1l);
        mensajeNuevo.setPregunta("cual es el sueldo");
        mensajeNuevo.setRespuesta("el sueldo es el minimo");
        mensaje.add(mensajeNuevo);
        Mockito.when(servicioMensajeriaMock.buscarPreguntasPorUsuario(mensaje.get(0).getIdMensaje())).thenReturn(mensaje);
    }

    private ModelAndView cuandoUnProfesionalEntraASuMensajeria() {

        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("2");

        when(this.httpSessionMock.getAttribute("rolID")).thenReturn("2");

        return controladorMensajeria.verRespuestas(httpServletRequestMock);
    }

    private void entoncesMeLlevaALaVistaRespuestasYTieneUnNuevoCorreo(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("casillaProfesional");
    }
}
