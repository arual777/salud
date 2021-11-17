package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosMensajeria;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.repositorios.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

public class ServicioMensajeriaTest {

    private RepositorioMensaje repositorioMensaje = mock(RepositorioMensaje.class);
    private RepositorioAsistencia repositorioAsistencia = mock(RepositorioAsistencia.class);
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
   private ServicioMensajeria servicioMensajeria = new ServicioMensajeriaImpl(repositorioMensaje, repositorioAsistencia, repositorioUsuario);


    /**@Test(expected = Exception.class)
    public void siElProfesionalQuiereEnviarUnaPreguntaVaciaDaError() throws Exception{
        dadoQueNoExistePregunta();
        Mensaje creado = cuandoElProfesionalEnviaPreguntaSinTexto();
        entoncesLaPreguntaNoSeGuarda(creado);

    }

    private void entoncesLaPreguntaNoSeGuarda(Mensaje creado) {
        {
           assertThat(creado).isNull();
        }
    }

    private Mensaje cuandoElProfesionalEnviaPreguntaSinTexto() throws Exception{
       Mensaje mensaje = new Mensaje();
          when(repositorioMensaje.crearPregunta(mensaje)).thenReturn(null);
    }

    private void dadoQueNoExistePregunta() {

        Mensaje mensaje = null;
    }**/
}
