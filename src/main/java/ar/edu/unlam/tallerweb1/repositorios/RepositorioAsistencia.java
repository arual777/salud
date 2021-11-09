package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Turno;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface RepositorioAsistencia {

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciasMensuales();

    List<Asistencia> buscarAsistenciasPorDia();

    List<Asistencia> buscarAsistenciaParaLaNoche(String tipo_turno);

    List<Asistencia> buscarAsistenciaPorNombre(String nombre);

    List<Asistencia> buscarAsistenciasPorZona( String zona );

    List<Asistencia> buscarAsistenciasPorNombre( String nombre );

    Asistencia buscarAsistenciaPorId(long id);

    void guardar(Asistencia asistencia);

    void actualizar(Asistencia asistencia);

    List<Asistencia> buscarTodosLosEmpleos();

    void eliminarSolicitudDeEmpleo(Long id);

   Asistencia buscarAsistenciaPorNombreEspecifico(String nombre);
}
