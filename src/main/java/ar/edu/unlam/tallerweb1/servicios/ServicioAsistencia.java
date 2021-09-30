package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;

import java.util.List;

public interface ServicioAsistencia {

    Asistencia crearServicio(String name);

    Asistencia buscarAsistenciaPorId(long id) throws Exception;

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciasMensuales();

    List<Asistencia> buscarAsistenciasPorDia();
}
