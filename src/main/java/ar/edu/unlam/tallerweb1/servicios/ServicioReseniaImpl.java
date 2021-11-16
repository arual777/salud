package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.controladores.DatosResenia;
import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
    public ReseniaAProfesional registrarResenia(DatosResenia datos) throws Exception {
        ReseniaAProfesional reseniaAProfesionalNueva = new ReseniaAProfesional();

        List <ReseniaAProfesional> reseniasAProfesional = repositorioResenia.buscarReseniaPorClienteYProfesional
                                                        (datos.getIdUsuarioCliente(), datos.getIdUsuarioProfesional());

        if (!reseniasAProfesional.isEmpty()){
            throw new Exception();
        }

        Usuario usuarioCliente = repositorioUsuario.buscarUsuario(datos.getIdUsuarioCliente());
        Usuario usuarioProfesional = repositorioUsuario.buscarUsuario(datos.getIdUsuarioProfesional());

        reseniaAProfesionalNueva.setCalificacion(datos.getCalificacion());
        reseniaAProfesionalNueva.setComentario(datos.getComentario());
        reseniaAProfesionalNueva.setIdUsuarioCliente(usuarioCliente);
        reseniaAProfesionalNueva.setIdUsuarioProfesional(usuarioProfesional);

        repositorioResenia.guardarResenia(reseniaAProfesionalNueva);
        return reseniaAProfesionalNueva;
    }

    @Override
    public void registrarReseniaACliente(DatosResenia datos)  throws Exception {
        ReseniaACliente reseniaNueva = new ReseniaACliente();

        List <ReseniaACliente> reseniasACliente = repositorioResenia.buscarReseniaAClientePorClienteYProfesional
                (datos.getIdUsuarioCliente(), datos.getIdUsuarioProfesional());

        if (!reseniasACliente.isEmpty()){
            throw new Exception();
        }

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
    public List<ReseniaAProfesional> buscarResenias(long id){
        return repositorioResenia.buscarReseniaPorId(id);
    }

    @Override
    public List<ReseniaAProfesional> buscarReseniasPorIdProfesional(long id){
        return repositorioResenia.buscarReseniasPorIdProfesional(id);
    }

    @Override
    public List<ReseniaACliente> buscarReseniasAClientePorIdCliente(long id){
        return repositorioResenia.buscarReseniasAClientePorIdCliente(id);
    }

    @Override
    public List<ReseniaAProfesional> buscarReseniaPorClienteYProfesional(long idCliente, long idProfesional){
        return repositorioResenia.buscarReseniaPorClienteYProfesional(idCliente,idProfesional);
    }

    @Override
    public List<ReseniaACliente> buscarReseniaAClientePorClienteYProfesional(long idCliente, long idProfesional){
        return repositorioResenia.buscarReseniaAClientePorClienteYProfesional(idCliente,idProfesional);
    }

}
