package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RepositorioPostulacion {

    void guardar(Postulacion postulacion);

    List<Postulacion> buscarPostulacionesPorIdUsuario(Long id);

    Postulacion buscarPostulacionesPorId(long idProfesional);

    boolean verSiElUsuarioYaEstaPostulado(Long idAsistencia, Long idUsuario);

    List<Postulacion>  buscarPostulacionesPorId(Long id);

    void actualizarPostulacionAContratada(Postulacion postulacion);

    List<Postulacion> buscarPostulacionesPorCreador(Long usuarioId);

    List<Postulacion> buscarPostulacionesPorCreadorNoAceptados(Long usuarioId);

    List<Postulacion> buscarPostulaciones();

    Postulacion buscarPostulacion(long idPostulacion);

    //Metodos creados para mostrar empleos coordinados (que hayan aceptado al postulante)
    //Para asi, desde alli, ir a reseniar al profesional
    List<Postulacion> buscarEmpleosOfrecidosCoordinados(long id);
}
