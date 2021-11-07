package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Resenia;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;

import java.util.List;

public interface RepositorioResenia {

    void guardarResenia(Resenia resenia);

    void guardarReseniaACliente(ReseniaACliente reseniaACliente);

    List<Resenia> buscarReseniaPorId(Long id);

    List<Resenia> buscarReseniasPorIdProfesional(Long id);

    List<ReseniaACliente> buscarReseniasAClientePorIdCliente(Long id);
}
