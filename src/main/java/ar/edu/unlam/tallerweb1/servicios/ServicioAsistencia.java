package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;

import java.util.List;

public interface ServicioAsistencia {

    Asistencia crearServicio(DatosAsistencia datos);

    Asistencia buscarAsistenciaPorId(long id) throws Exception;

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciasMensuales();

    List<Asistencia> buscarAsistenciasPorDia();

    List<Asistencia> buscarTodosLosEmpleos();

    void eliminarSolicitudDeEmpleo(Long id);

    Asistencia actualizarAsistencia(DatosAsistencia datos);

}
