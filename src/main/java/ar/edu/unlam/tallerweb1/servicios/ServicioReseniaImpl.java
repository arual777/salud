package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.controladores.DatosResenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioResenia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioResenia")
@Transactional
public class ServicioReseniaImpl implements ServicioResenia {

    private RepositorioUsuario repositorioUsuario;
    private RepositorioResenia repositorioResenia;


    @Override
    public void registrarResenia(DatosResenia datos) {
        Resenia reseniaNueva = new Resenia();

        reseniaNueva.setCalificacion(datos.getCalificacion());
        reseniaNueva.setComentario(datos.getComentario());

        Usuario usuarioCliente = repositorioUsuario.buscarUsuario(datos.getIdUsuarioCliente());
        Usuario usuarioProfesional = repositorioUsuario.buscarUsuario(datos.getIdUsuarioProfesional());

        reseniaNueva.setIdUsuarioCliente(usuarioCliente);
        reseniaNueva.setIdUsuarioProfesional(usuarioProfesional);

        repositorioResenia.guardarResenia(reseniaNueva);
    }
}
