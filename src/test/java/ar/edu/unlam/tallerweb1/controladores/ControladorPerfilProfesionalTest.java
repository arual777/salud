package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesional;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ControladorPerfilProfesionalTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpSession session;

    @Before
    public void iniciarInjecciones(){
        MockitoAnnotations.initMocks(this);
    }

    private ServicioPerfilProfesional servicioPerfilProfesional = mock(ServicioPerfilProfesional.class);
    private ControladorPerfilProfesional controladorPerfilProfesional = new ControladorPerfilProfesional(servicioPerfilProfesional);
    private static final DatosRegistroProfesional PERFILPROFESIONAL
            = new DatosRegistroProfesional("Bianca Della Vecchia", "bianca@gmail.com", "blablablablabla"
    ,"1136008899","2002-06-02", 1);


    /*@Test
    public void puedoRegistrarPerfilProfesional() {

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userID")).thenReturn(1L);

        ModelAndView mav = whenRegistroElPerfilProfesional(PERFILPROFESIONAL, request);
        thenElRegistroEsExitoso(mav);
    }*/

    @Test
    public void sinSesionNoPuedoIrARegistrarPerfilProfesional(){
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userID")).thenReturn(null);

        ModelAndView mav = whenVoyAIrARegistrarPerfilProfesional(request);
        thenMuestraErrorSesion(mav);
    }

    @Test
    public void sinSesionNoPuedoRegistrarUnPerfilProfesional(){
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userID")).thenReturn(null);

        ModelAndView mav = whenRegistroElPerfilProfesional(PERFILPROFESIONAL, request);
        thenMuestraErrorSesion(mav);
    }

    @Test
    public void sinSesionNopuedoEditarPerfilProfesional(){
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userID")).thenReturn(null);
        ModelAndView mav = whenVoyAirAEditarPerfilProfesional(1L, PERFILPROFESIONAL, request);
        thenMuestraErrorSesion(mav);
    }

    /*
    @Test
    public void puedoIrAEditarPerfilProfesional(){
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userID")).thenReturn(1L);

        ModelAndView mav =  whenVoyAirAEditarPerfilProfesional(1L, PERFILPROFESIONAL, request);
        thenPuedoIrAEditarPerfilProfesional(mav);
    }
    */


    private ModelAndView whenRegistroElPerfilProfesional(DatosRegistroProfesional datos, HttpServletRequest request) {
        return controladorPerfilProfesional.registroPerfilProfesional(datos, request);
    }

    private ModelAndView whenVoyAIrARegistrarPerfilProfesional(HttpServletRequest request){
        return controladorPerfilProfesional.irARegistrarPerfilProfesional(request);
    }

    private ModelAndView whenVoyAirAEditarPerfilProfesional(Long id, DatosRegistroProfesional datos, HttpServletRequest request){
        return controladorPerfilProfesional.irAEditarPerfilProfesional(id, datos, request);
    }

    private void thenElRegistroEsExitoso(ModelAndView mav) {
        //assertThat(mav.getModel().get("msg")).isEqualTo("Su perfil profesional ha sido cargado");
    }

    private void thenMuestraErrorSesion(ModelAndView mav){
        assertThat(mav.getModel().get("msglogeado")).isEqualTo("No ingresaste en el sistema");
    }

    private void thenPuedoIrAEditarPerfilProfesional(ModelAndView mav){
        assertThat(mav.getViewName()).isEqualTo("editarPerfilProfesional");
    }




}
