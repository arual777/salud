package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.modelo.Zona;

import java.util.List;

public interface ServicioAsistencia {

    Asistencia crearServicio(DatosAsistencia datos);

    Asistencia buscarAsistenciaPorId(long id) throws Exception;

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciasMensuales();

    List<Asistencia> buscarAsistenciasPorDia();

    List<Asistencia> buscarTodosLosEmpleos();

    List<Asistencia> buscarAsistenciasPorZona(Long idZona );

    List<Asistencia> buscarAsistenciasPorNombre( String nombre );

    Asistencia actualizarAsistencia(DatosAsistencia datos);

    void eliminarSolicitudDeEmpleo(Long id);

    Asistencia buscarAsistenciaPorNombreEspecifico(String nombre);

    void crearPostulacion(DatosPostulacion datosPostulacion) throws Exception;

    List<Postulacion> buscarPostulacionesPorUsuario(long id);
}
