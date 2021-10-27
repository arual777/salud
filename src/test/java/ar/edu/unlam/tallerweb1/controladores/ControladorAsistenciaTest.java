package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsistencia;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorAsistenciaTest {

    private ServicioAsistencia servicioAsistencia = mock(ServicioAsistencia.class);
    private HttpServletRequest httpServletRequestMock =  mock(HttpServletRequest.class);
    private HttpSession httpSessionMock = mock(HttpSession.class);
    private ControladorAsistencias controladorAsistencias = new ControladorAsistencias(servicioAsistencia);
    private final static DatosAsistencia SOLICITUD_NUEVA = new DatosAsistencia();

    private ServicioAsistencia servicioAsistenciaMock = mock(ServicioAsistencia.class);
    private ControladorAsistencias controladorAsistenciasMock = new ControladorAsistencias(servicioAsistenciaMock);
    private final static Asistencia SOLICITUD_CON_ID = new Asistencia(33L);
    private final static Asistencia SOLICITUD_CON_NOMBRE = new Asistencia("Ana");
    private final static Postulacion POSTULACION = new Postulacion(1L);
    private DatosPostulacion datosPostulacion = new DatosPostulacion();
    private final static Usuario usuarioProfesiona = new Usuario(1L);

    @Test
    public void queUnProfesionalPuedaPostularseAUnEmpleo() throws Exception {
        dadoQueExisteUnProfesionalLogueadoYUnaSolicitudAsistencia();
        ModelAndView mav = cuandoSePostulaAUnEmpleo(datosPostulacion);
        entoncesMeLlevaALaVistaDePostulacionConMensaje(mav);

    }

    private void entoncesMeLlevaALaVistaDePostulacionConMensaje(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("postulaciones");
    }

    private void dadoQueExisteUnProfesionalLogueadoYUnaSolicitudAsistencia() {
           }

    private ModelAndView cuandoSePostulaAUnEmpleo(DatosPostulacion datosPostulacion) throws Exception {

        when(this.httpServletRequestMock.getSession()).thenReturn(httpSessionMock);

        when(this.httpSessionMock.getAttribute("userID")).thenReturn("1");
        when(this.httpSessionMock.getAttribute("rolID")).thenReturn("1");
        return controladorAsistencias.postularmeAEmpleo(httpServletRequestMock, datosPostulacion);
    }

    @Test
    public void queLaSolicitudAsistenciaTengaIdEspecificado() throws Exception {
        givenUnaSolicitudAsistencia(SOLICITUD_CON_ID);
        ModelAndView mav = whenLaSolicitudTieneId(SOLICITUD_CON_ID);
        thenLaSolicitudTieneELIdEspecificado(mav);
    }

    private void thenLaSolicitudTieneElNombreEspecificado(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("detalle-solicitud");
        assertThat(mav.getModel().get("nombre")).isEqualTo(SOLICITUD_CON_NOMBRE.getNombre());
    }

    @Test
    public void queLaSolicitudAsistenciaTengaNombreEspecificado() throws Exception {
        givenUnaSolicitudAsistenciaConNombre(SOLICITUD_CON_NOMBRE);
        ModelAndView mav = whenLaSolicitudTieneNombre(SOLICITUD_CON_NOMBRE);
        thenLaSolicitudTieneElNombreEspecificado(mav);
    }

    private ModelAndView whenLaSolicitudTieneNombre(Asistencia solicitudConNombre) {
        ModelMap model = new ModelMap();
        Asistencia asistencia = servicioAsistenciaMock.buscarAsistenciaPorNombreEspecifico(solicitudConNombre.getNombre());
        model.put("nombre", asistencia.getNombre());

        return new ModelAndView("detalle-solicitud", model);
    }

    private void givenUnaSolicitudAsistenciaConNombre(Asistencia solicitudConNombre) {
        Mockito.when(servicioAsistenciaMock.buscarAsistenciaPorNombreEspecifico(solicitudConNombre.getNombre())).thenReturn(solicitudConNombre);
    }

    private void thenLaSolicitudTieneELIdEspecificado(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("detalle-solicitud");
        assertThat(mav.getModel().get("id")).isEqualTo(SOLICITUD_CON_ID.getId());
    }

    private ModelAndView whenLaSolicitudTieneId(Asistencia solicitudConNombre) throws Exception {
        ModelMap model = new ModelMap();
        Asistencia asistencia = servicioAsistenciaMock.buscarAsistenciaPorId(solicitudConNombre.getId());
        model.put("id", asistencia.getId());

        return new ModelAndView("detalle-solicitud", model);
    }

    private void givenUnaSolicitudAsistencia(Asistencia solicitudConNombre) throws Exception {
        Mockito.when(servicioAsistenciaMock.buscarAsistenciaPorId(solicitudConNombre.getId())).thenReturn(solicitudConNombre);
    }

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

    /*@Test
    public void verTodosLosProfesionalesPostuladosParaAsistenciasDeUnUsuario(){
        Postulacion postulacion = new Postulacion();
        //postulacion.setId(1L);
        givenProfesionalesPostulados(postulacion);
        ModelAndView mav = whenLosProfesionalesSePostularonAAsistenciaEspecificadaPorId(usuarioProfesiona);
        thenVeoTodosLosPostulados(mav);
    }

    private void thenVeoTodosLosPostulados(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("postulaciones");
        //assertThat(mav.getModel().get("postulaciones")).isEqualTo(usuarioProfesiona.getId());
    }

    private ModelAndView whenLosProfesionalesSePostularonAAsistenciaEspecificadaPorId(Usuario usuarioProfesional) {
        ModelMap model = new ModelMap();
        List<Postulacion> postulaciones = servicioAsistenciaMock.buscarPostulacionesPorCreador(usuarioProfesional.getId());

        model.put("postulaciones", postulaciones);
        return new ModelAndView("postulaciones", model);
    }

    private void givenProfesionalesPostulados(Postulacion postulacion) {
        when(servicioAsistenciaMock.buscarPostulacionesPorCreador(postulacion.getProfesional().getId())).thenReturn(postulacion);
    }
*/
 /*   @Test
    public void contratarUnProfesionalDeLaListaDePostulados() {
        givenPostuladoId(POSTULACION);
        ModelAndView mav = whenContratoAUnProfesional(POSTULACION);
        thenLoContratoYUpdateEnPostulacion(mav);
    }

    private ModelAndView whenContratoAUnProfesional(Postulacion postulacion) {
        ModelMap model = new ModelMap();
        Postulacion datosPostulacion = servicioAsistenciaMock.buscarPostulacionesPorId(postulacion.getProfesional().getId());
        model.put("idUsuario", datosPostulacion.getProfesional().getId());
        model.put("msg", "Usted ha contratado a " + datosPostulacion.getProfesional().getId() + " para la asistencia " + datosPostulacion.getAsistencia().getDescripcion());

        return new ModelAndView("contratado/{id}", model);
    }

    private void givenPostuladoId(Postulacion postulacion) {
        Mockito.when(servicioAsistenciaMock.buscarPostulacionesPorId(postulacion.getProfesional().getId())).thenReturn((postulacion));
    }

    private void thenLoContratoYUpdateEnPostulacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("contratado");
        assertThat(mav.getModel().get("idUsuario")).isEqualTo(POSTULACION);
    }
  */
}


