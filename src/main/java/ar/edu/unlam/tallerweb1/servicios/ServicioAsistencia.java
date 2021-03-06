package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosFiltro;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;

import java.util.List;

public interface ServicioAsistencia {

    Asistencia crearServicio(DatosAsistencia datos);

    Asistencia buscarAsistenciaPorId(long id) throws Exception;

    List<Asistencia> buscarTodasLasAsistencias();

    List<Asistencia> buscarAsistenciasMensuales();

    List<Asistencia> buscarAsistenciasPorDia();

    List<Asistencia> buscarAsistenciaPorIdDelCliente(Long idUsuario);

    Asistencia actualizarAsistencia(DatosAsistencia datos);

    void eliminarSolicitudDeEmpleo(Long id);

    Asistencia buscarAsistenciaPorNombreEspecifico(String nombre);

    void crearPostulacion(DatosPostulacion datosPostulacion) throws Exception;

    List<Postulacion> buscarPostulacionesPorUsuario(long id);

    Postulacion buscarPostulacionesPorId(long idProfesional);

    Postulacion actualizarPostulacionContratada(DatosPostulacion datosPostulacion);

    List<Postulacion> buscarPostulacionesPorCreador(Long usuarioId);

    List<Postulacion> buscarPostulaciones();

    List<Postulacion> buscarPostulacionesPorCreadorNoAceptados(Long idUsuario);



    //Metodos creados para mostrar empleos coordinados (que hayan aceptado al postulante)
    //Para asi, desde alli, ir a reseniar al profesional
    List<Postulacion> buscarEmpleosOfrecidosCoordinados(long id);

    List<Asistencia> buscarEmpleos(DatosFiltro datosFiltro);

     List<Asistencia> buscarAsistenciasSinPostulantes(Long idUsuario);
}
