package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cuenta;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//sirve para limpiar la base de datos en memoria cuando se corre cada test
public class RepositorioUsuarioTest extends SpringTest {

    private static final String ADMIN = "ADMIN";
    private static final String INVITADO = "INVITADO";

    @Before
    public void s(){
        session().clear();
    }

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    @Rollback @Transactional
    public void buscarPorRolDeberiaDevolverSoloUsuarioConEseRol(){
        givenExistenUsuarioConRol(1L,ADMIN, 2);
        givenExistenUsuarioConRol(2L, INVITADO, 3);

        List<Usuario> usuarios = whenBuscoUsuarioConRol(1L);

        thenEncuentro(usuarios,2);
    }

    @Test
    @Rollback @Transactional
    public void buscarPorRoNolDeberiaDevolverResultados(){
        givenExistenUsuarioConRol(1L,ADMIN, 2);

        List<Usuario> usuarios = whenBuscoUsuarioConRol(2L);

        thenEncuentro(usuarios,0);
    }

    @Test
    @Rollback @Transactional
    public void buscarUsuariosConMailDeAdmin(){
        givenExistenUsuarioConRol(1L, ADMIN, 2);
        givenExistenUsuarioConRol(2L, INVITADO, 3);

        List<Usuario> usuarios = whenBuscoUsuarioConMailDe(ADMIN);

        thenEncuentro(usuarios,2);
    }

    private void givenExistenUsuarioConRol(Long rolId, String rolDescripcion, int cantidadDeUsuarios) {

        Rol r = new Rol();
        r.setDescripcion(rolDescripcion);
        session().save(r);
        Rol rb = repositorioUsuario.obtenerRol(rolId);
        for(int i = 0; i < cantidadDeUsuarios; i++){
            Usuario usuario = new Usuario();
            usuario.setEmail("usuario-"+i+"-"+rolDescripcion+"@usuario.com");
            usuario.setPassword("123"+i);
            usuario.setRol(rb);

            Cuenta cuenta = new Cuenta();
            cuenta.setCreada(new Date());
            usuario.setCuenta(cuenta);

            session().save(usuario);
        }
    }

    private List<Usuario> whenBuscoUsuarioConMailDe(String mail) {
        return repositorioUsuario.buscarUsuarioConMailLike(mail);
    }

    private void thenEncuentro(List<Usuario> usuarios, int usuariosEncontrados) {
        assertThat(usuarios).hasSize(usuariosEncontrados);
    }

    private List<Usuario> whenBuscoUsuarioConRol(long rol) {
        return repositorioUsuario.buscarUsuarioPorRol(rol);
    }
}
