package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ControladorAsistenciaTest {

    private ServicioAsistencia servicioAsistencia = mock(ServicioAsistencia.class);
    private HttpServletRequest httpServletRequestMock =  mock(HttpServletRequest.class);
    private HttpSession httpSessionMock = mock(HttpSession.class);
    private ControladorAsistencias controladorAsistencias = new ControladorAsistencias(servicioAsistencia);
    private final static DatosAsistencia SOLICITUD_NUEVA = new DatosAsistencia();

   @Test
   public void queSePuedaCrearUnaNuevaSolicitudDeAsistencia(){

       dadoQueNoExisteUnaSolicitud(SOLICITUD_NUEVA);
       ModelAndView mav = cuandoCreoUnaSolicitud(SOLICITUD_NUEVA);
       DatosAsistencia a = new DatosAsistencia();
       entoncesLaCreacionEsExitosa(mav);
   }

    private ModelAndView cuandoCreoUnaSolicitud(DatosAsistencia datos) {
       
       when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("1");
                            //httpSessionMock.getAttribute("userID").
        return controladorAsistencias.crearNuevaSolicitudDeAsistencia(httpServletRequestMock, datos);
    }

    private void dadoQueNoExisteUnaSolicitud(DatosAsistencia solicitudNueva) {
    }

    private void entoncesLaCreacionEsExitosa(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("redirect:/ir-a-asistencias");
    }

    @Test
    public void queSePuedaEditarUnaSolicitud() throws Exception {
       dadoQueExisteUnaSolicitud(SOLICITUD_NUEVA);
       ModelAndView mav = cuandoEditoUnaSolicitud(SOLICITUD_NUEVA);
       entoncesSeEdita(mav);
    }

    private void entoncesSeEdita(ModelAndView mav) {
        assertThat(mav.getModel().get("nombre")).isEqualTo(SOLICITUD_NUEVA.getNombre());
        assertThat(mav.getViewName()).isEqualTo("redirect:/ir-a-asistencias");
    }

    private ModelAndView cuandoEditoUnaSolicitud(DatosAsistencia datos) throws Exception {
       return controladorAsistencias.editar(datos);
    }

    private void dadoQueExisteUnaSolicitud(DatosAsistencia datos) {
    }

    @Test
    public void queSeBusqueUnaSolicitudDeAsistenciaPorId() throws Exception {

        existeUnaSolicitud(SOLICITUD_NUEVA);
        ModelAndView mav = cuandoBuscoUnaSolicitudDeAsistencia(SOLICITUD_NUEVA);
        entoncesEncuentroLaSolicitudDeAsistencia(mav);
    }
    private void existeUnaSolicitud(DatosAsistencia datos) {
    }

    private void entoncesEncuentroLaSolicitudDeAsistencia(ModelAndView mav) {
    assertThat(mav.getModel().equals(SOLICITUD_NUEVA.getId()));
    }

   private ModelAndView cuandoBuscoUnaSolicitudDeAsistencia(DatosAsistencia solicitudDeAsistencia) throws Exception {
      return controladorAsistencias.buscarAsistenciaPorId(solicitudDeAsistencia.getId());
    }
}


