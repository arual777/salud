package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class ControladorAsistenciaTest {

    private ServicioAsistencia servicioAsistencia = mock(ServicioAsistencia.class);
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
        return controladorAsistencias.mostrarTodosLosEmpleos(datos);

    }

    private void dadoQueNoExisteUnaSolicitud(DatosAsistencia solicitudNueva) {
    }

    private void entoncesLaCreacionEsExitosa(ModelAndView mav) {
        assertThat(mav.getModel().get("nombre")).isEqualTo(SOLICITUD_NUEVA.getNombre());
        assertThat(mav.getViewName()).isEqualTo("empleos-publicados");
        assertThat(mav.getModel().get("idFrecuencia")).isEqualTo(SOLICITUD_NUEVA.getIdFrecuencia());
        assertThat(mav.getViewName()).isEqualTo("empleos-publicados");
    }

    @Test
    public void queSePuedaEditarUnaSolicitud() throws Exception {
       dadoQueExisteUnaSolicitud(SOLICITUD_NUEVA);
       ModelAndView mav = cuandoEditoUnaSolicitud(SOLICITUD_NUEVA);
       entoncesSeEdita(mav);
    }

    private void entoncesSeEdita(ModelAndView mav) {
        assertThat(mav.getModel().get("nombre")).isEqualTo(SOLICITUD_NUEVA.getNombre());
        assertThat(mav.getViewName()).isEqualTo("empleos-publicados");
    }

    private ModelAndView cuandoEditoUnaSolicitud(DatosAsistencia datos) throws Exception {
       return controladorAsistencias.editar(datos);
    }

    private void dadoQueExisteUnaSolicitud(DatosAsistencia datos) {
    }

   /* @Test
    public void queSeBusqueUnaSolicitudDeAsistenciaPorId() throws Exception {

        dadoQueExisteUnaSolicitud(SOLICITUD_NUEVA);
        ModelAndView mav = cuandoBuscoUnaSolicitudDeAsistencia(SOLICITUD_NUEVA);
       entoncesEncuentroLaSolicitudDeAsistencia(mav);
    }

    private void dadoQueExisteUnaSolicitud(DatosAsistencia solicitudNueva) {
    }

    private void entoncesEncuentroLaSolicitudDeAsistencia(ModelAndView mav) {
    assertThat(mav.getModel().get("idAsistencia").equals(SOLICITUD_NUEVA.getIdDatosAsistencia()));
    }

   private ModelAndView cuandoBuscoUnaSolicitudDeAsistencia(DatosAsistencia solicitudDeAsistencia) throws Exception {
      return controladorAsistencias.buscarAsistenciaPorId(solicitudDeAsistencia.getIdDatosAsistencia());
    } */
}


