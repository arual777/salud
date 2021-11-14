package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosResenia;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioResenia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioReseniaTest {

    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private RepositorioResenia repositorioResenia = mock(RepositorioResenia.class);
    private ServicioResenia servicioResenia = new ServicioReseniaImpl(repositorioUsuario, repositorioResenia);
    private DatosResenia datosResenia = new DatosResenia(8, "brinda buen servicio", 1L, 2L);

    @Test(expected = Exception.class)
    public void siMeResenioAMismoProfesionalDaError() throws Exception {
        givenReseniaYaExiste(1L,2L);
        ReseniaAProfesional reseniaAProfesional = whenRegistroResenia(datosResenia);
        thenLaReseniaNoSeGuarda();
    }

    @Test
    public void siNoExistiaReseniaPuedoReseniar() throws Exception{
        givenReseniaNoExiste(1L, 2L);
        ReseniaAProfesional reseniaAProfesional = whenRegistroResenia(datosResenia);
        thenLaReseniaSeGuarda(reseniaAProfesional);

    }


    public void givenReseniaYaExiste(long idCliente, long idProfesional){
        ReseniaAProfesional resenia1 = new ReseniaAProfesional();
        List <ReseniaAProfesional> resenias = new ArrayList<>();
        resenias.add(resenia1);
        when(repositorioResenia.buscarReseniaPorClienteYProfesional(idCliente, idProfesional)).thenReturn(resenias);
    }

    public void givenReseniaNoExiste(long idCliente, long idProfesional){
        List <ReseniaAProfesional> resenias = new ArrayList<>();
        when(repositorioResenia.buscarReseniaPorClienteYProfesional(idCliente, idProfesional)).thenReturn(resenias);
    }

    public ReseniaAProfesional whenRegistroResenia(DatosResenia datosResenia) throws Exception{
        return servicioResenia.registrarResenia(datosResenia);
    }

    public void thenLaReseniaNoSeGuarda(){
        verify(repositorioResenia, never()).guardarResenia(any());
    }

    public void thenLaReseniaSeGuarda(ReseniaAProfesional reseniaAProfesional){
        assertThat(reseniaAProfesional).isNotNull();
        verify(repositorioResenia,times(1)).guardarResenia(any());
    }

}