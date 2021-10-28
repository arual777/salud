package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Resenia;

import java.util.List;

public interface RepositorioResenia {

    void guardarResenia(Resenia resenia);

    List<Resenia> buscarReseniaPorId(Long id);
}
