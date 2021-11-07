package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.controladores.DatosResenia;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPerfilProfesional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioResenia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioResenia")
@Transactional
public class ServicioReseniaImpl implements ServicioResenia {

    private RepositorioUsuario repositorioUsuario;
    private RepositorioResenia repositorioResenia;

    @Autowired
    public ServicioReseniaImpl (RepositorioUsuario repositorioUsuario, RepositorioResenia repositorioResenia){
        this.repositorioUsuario=repositorioUsuario;
        this.repositorioResenia=repositorioResenia;
    }


    @Override
    public void registrarResenia(DatosResenia datos) {
        Resenia reseniaNueva = new Resenia();

        Usuario usuarioCliente = repositorioUsuario.buscarUsuario(datos.getIdUsuarioCliente());
        Usuario usuarioProfesional = repositorioUsuario.buscarUsuario(datos.getIdUsuarioProfesional());

        reseniaNueva.setCalificacion(datos.getCalificacion());
        reseniaNueva.setComentario(datos.getComentario());
        reseniaNueva.setIdUsuarioCliente(usuarioCliente);
        reseniaNueva.setIdUsuarioProfesional(usuarioProfesional);

        repositorioResenia.guardarResenia(reseniaNueva);
    }

    @Override
    public void registrarReseniaACliente(DatosResenia datos) {
        ReseniaACliente reseniaNueva = new ReseniaACliente();

        Usuario usuarioCliente = repositorioUsuario.buscarUsuario(datos.getIdUsuarioCliente());
        Usuario usuarioProfesional = repositorioUsuario.buscarUsuario(datos.getIdUsuarioProfesional());

        reseniaNueva.setCalificacion(datos.getCalificacion());
        reseniaNueva.setComentario(datos.getComentario());
        reseniaNueva.setIdUsuarioCliente(usuarioCliente);
        reseniaNueva.setIdUsuarioProfesional(usuarioProfesional);

        repositorioResenia.guardarReseniaACliente(reseniaNueva);
    }

    @Override
    public List<Usuario> traerListaProfesionales(long idRol){
        return repositorioUsuario.buscarUsuarioPorRol(idRol);
    }

    @Override
    public Usuario buscarUsuario(long id){
        return repositorioUsuario.buscarUsuario(id);
    }

    @Override
    public List<Resenia> buscarResenias(long id){
        return repositorioResenia.buscarReseniaPorId(id);
    }

    @Override
    public List<Resenia> buscarReseniasPorIdProfesional(long id){
        return repositorioResenia.buscarReseniasPorIdProfesional(id);
    }

    @Override
    public List<ReseniaACliente> buscarReseniasAClientePorIdCliente(long id){
        return repositorioResenia.buscarReseniasAClientePorIdCliente(id);
    }
}
