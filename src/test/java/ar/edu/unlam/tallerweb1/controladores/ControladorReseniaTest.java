package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioResenia;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorReseniaTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpSession session;

    @Before
    public void iniciarInjecciones(){
        MockitoAnnotations.initMocks(this);
    }

    private ServicioResenia servicioResenia = mock(ServicioResenia.class);
    private ControladorResenia controladorResenia = new ControladorResenia(servicioResenia);

    @Test
    public void sinSesionNoPuedoReseniar(){
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userID")).thenReturn(null);

        ModelAndView mav = whenVoyAIrAReseniar(request);
        thenMuestraErrorSesion(mav);
    }

    private ModelAndView whenVoyAIrAReseniar(HttpServletRequest request){
        return controladorResenia.irAReseniar(1L, request);
    }

    private void thenMuestraErrorSesion(ModelAndView mav){
        assertThat(mav.getModel().get("msglogeado")).isEqualTo("No ingresaste en el sistema");
    }


}
