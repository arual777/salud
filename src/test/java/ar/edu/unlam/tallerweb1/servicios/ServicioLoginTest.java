package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioLoginTest {

    public static final String EMAIL = "seba@seba.com";
    private static final long ROL = 1L;
    private RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private ServicioLogin servicioLogin = new ServicioLoginImpl(repositorioUsuario);

    @Test(expected = Exception.class)
    public void siMeRegistroConUsuarioExistenteDaError() throws Exception {
        givenUsuarioYaExiste(EMAIL);
        whenResgistro(EMAIL);
        thenElUsuarioNoSeGuarda();
    }

    @Test
    public void deberiaRegistrarUsuarioSiNoExiste() throws Exception {
        givenUsuarioNoExiste(EMAIL);
        Usuario creado = whenResgistro(EMAIL);
        thenElRegistroEsExitoso(creado);
    }

    private void givenUsuarioNoExiste(String email)
    {
        Rol rol = new Rol();
        rol.setId(ROL);
        when(repositorioUsuario.obtenerRol(ROL)).thenReturn(rol);
        when(repositorioUsuario.buscar(email)).thenReturn(null);
    }

    private void givenUsuarioYaExiste(String email) {
        Rol rol = new Rol();
        rol.setId(ROL);
        when(repositorioUsuario.obtenerRol(ROL)).thenReturn(rol);
        when(repositorioUsuario.buscar(email)).thenReturn(new Usuario());
    }

    private Usuario whenResgistro(String email) throws Exception {
        return servicioLogin.registrar(email, "67447",ROL);
    }

    private void thenElUsuarioNoSeGuarda() {
        verify(repositorioUsuario, never()).guardar(any());
    }

    private void thenElRegistroEsExitoso(Usuario creado) {
        assertThat(creado).isNotNull();
        assertThat(creado.getEmail()).isEqualTo(EMAIL);
        assertThat(creado.getRol().getId()).isEqualTo(ROL);
        verify(repositorioUsuario, times(1)).guardar(any());
    }
}
