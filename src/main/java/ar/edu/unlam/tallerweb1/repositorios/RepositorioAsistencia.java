package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;

import java.util.List;

public interface RepositorioAsistencia {

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciaParaLaNoche();
}
