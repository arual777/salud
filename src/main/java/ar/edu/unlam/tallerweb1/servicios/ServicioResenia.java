package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosResenia;
import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioResenia {
    void registrarResenia(DatosResenia datos);

    void registrarReseniaACliente(DatosResenia datos);

    List<Usuario> traerListaProfesionales(long idRol);

    Usuario buscarUsuario(long id);

    List<ReseniaAProfesional> buscarResenias(long idUsuario);

    List<ReseniaAProfesional> buscarReseniasPorIdProfesional(long id);

    List<ReseniaACliente> buscarReseniasAClientePorIdCliente(long id);
}
