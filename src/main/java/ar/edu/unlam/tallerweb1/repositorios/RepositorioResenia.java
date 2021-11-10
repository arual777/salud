package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;

import java.util.List;

public interface RepositorioResenia {

    void guardarResenia(ReseniaAProfesional reseniaAProfesional);

    void guardarReseniaACliente(ReseniaACliente reseniaACliente);

    List<ReseniaAProfesional> buscarReseniaPorId(Long id);

    List<ReseniaACliente> buscarReseniaAClientePorId(Long id);

    List<ReseniaAProfesional> buscarReseniasPorIdProfesional(Long id);

    List<ReseniaACliente> buscarReseniasAClientePorIdCliente(Long id);

    List<ReseniaAProfesional> buscarReseniaPorClienteYProfesional(long idCliente, long idProfesional);

    List<ReseniaACliente> buscarReseniaAClientePorClienteYProfesional(long idCliente, long idProfesional);
}
