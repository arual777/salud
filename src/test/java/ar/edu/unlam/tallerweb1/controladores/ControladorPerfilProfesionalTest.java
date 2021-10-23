package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPerfilProfesional;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class ControladorPerfilProfesionalTest {
/*
    private ServicioPerfilProfesional servicioPerfilProfesional = mock(ServicioPerfilProfesional.class);
    private ControladorPerfilProfesional controladorPerfilProfesional = new ControladorPerfilProfesional(servicioPerfilProfesional);
    private static final DatosRegistroProfesional PERFILPROFESIONAL
            = new DatosRegistroProfesional("Bianca Della Vecchia", "bianca@gmail.com", "blablablablabla"
    ,"1136008899","2002-06-02", 1);

    @Test
    public void puedoRegistrarPerfilProfesional() {

        Object request;
        ModelAndView mav = whenRegistroElPerfilProfesional(PERFILPROFESIONAL, HttpServletRequest request);
        thenElRegistroEsExitoso(mav);
    }

    private void thenElRegistroEsExitoso(ModelAndView mav) {
        assertThat(mav.getModel().get("msg")).isEqualTo("Su perfil profesional ha sido cargado");
    }

    private ModelAndView whenRegistroElPerfilProfesional(DatosRegistroProfesional datos, HttpServletRequest request) {
        return controladorPerfilProfesional.registroPerfilProfesional(datos, request);
    }

 */
}
