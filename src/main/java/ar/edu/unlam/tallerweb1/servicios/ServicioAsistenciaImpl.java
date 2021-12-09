package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosFiltro;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPerfilProfesional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostulacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("servicioAsistencia")
@Transactional
public class ServicioAsistenciaImpl implements ServicioAsistencia {

    private RepositorioAsistencia repositorioAsistencia;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPostulacion repositorioPostulacion;
    private RepositorioPerfilProfesional repositorioPerfilProfesional;

    @Autowired
    public ServicioAsistenciaImpl(RepositorioAsistencia repositorioAsistencia, RepositorioUsuario repositorioUsuario, RepositorioPostulacion repositorioPostulacion, RepositorioPerfilProfesional repositorioPerfilProfesional) {
        this.repositorioAsistencia = repositorioAsistencia;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPostulacion = repositorioPostulacion;
        this.repositorioPerfilProfesional = repositorioPerfilProfesional;
    }

    @Override
    public void crearPostulacion(DatosPostulacion datosPostulacion) throws Exception {
        if(repositorioPostulacion.verSiElUsuarioYaEstaPostulado(datosPostulacion.getIdAsistencia(), datosPostulacion.getIdUsuario())){
            throw new Exception("El usuario ya se postuló");
        }

        Postulacion nuevaPostulacion = new Postulacion();
//        PerfilProfesional perfilProfesional = repositorioPerfilProfesional.buscarCV(1L); //(datosPostulacion.getIdProfesional());
        Usuario usuario = repositorioUsuario.buscarUsuario(datosPostulacion.getIdUsuario());
        Asistencia asistencia = repositorioAsistencia.buscarAsistenciaPorId(datosPostulacion.getIdAsistencia());

        nuevaPostulacion.setProfesional(usuario);
        nuevaPostulacion.setAsistencia(asistencia);
        nuevaPostulacion.setAceptado(false);

        repositorioPostulacion.guardar(nuevaPostulacion);
    }

    @Override
    public List<Postulacion> buscarPostulacionesPorUsuario(long id) {
        return repositorioPostulacion.buscarPostulacionesPorIdUsuario(id);
    }

    @Override
    public Postulacion buscarPostulacionesPorId(long idProfesional) {
        return  repositorioPostulacion.buscarPostulacionesPorId(idProfesional);
    }

    @Override
    public Asistencia crearServicio(DatosAsistencia datos) {

        Asistencia nuevaAsistencia = new Asistencia();
        Usuario usuario = repositorioUsuario.buscarUsuario(datos.getIdUsuario());
        Tipo_Turno turno = new Tipo_Turno();
        Tipo_Asistencia frecuencia = new Tipo_Asistencia();
        Zona zona = new Zona();

        nuevaAsistencia.setNombre(datos.getNombre());
        nuevaAsistencia.setDescripcion(datos.getDescripcion());
        nuevaAsistencia.setCamaAdentro(datos.getCamaAdentro());
        nuevaAsistencia.setTarifa(datos.getTarifa());
        nuevaAsistencia.setUsuario(usuario);
        turno.setId(datos.getIdTurno());
        frecuencia.setId(datos.getIdFrecuencia());
        zona.setId(datos.getZona());

        nuevaAsistencia.setIdTurno(turno);
        nuevaAsistencia.setIdFrecuencia(frecuencia);
        nuevaAsistencia.setZona(zona);
        nuevaAsistencia.setLatitud(datos.getLatitud());
        nuevaAsistencia.setLongitud(datos.getLongitud());
        repositorioAsistencia.guardar(nuevaAsistencia);

        return nuevaAsistencia;
    }

    @Override
    public Postulacion actualizarPostulacionContratada(DatosPostulacion datosPostulacion) {
        Postulacion postulacion = repositorioPostulacion.buscarPostulacion(datosPostulacion.getIdPostulacion());
        postulacion.setAceptado(true);

        repositorioPostulacion.actualizarPostulacionAContratada(postulacion);
        return postulacion;
    }

    @Override
    public List<Postulacion> buscarPostulacionesPorCreador(Long usuarioId) {
        return repositorioPostulacion.buscarPostulacionesPorCreador(usuarioId);
    }


    @Override
    public List<Postulacion> buscarPostulaciones() {
        return repositorioPostulacion.buscarPostulaciones();
    }

    @Override
    public List<Postulacion> buscarPostulacionesPorCreadorNoAceptados(Long idUsuario) {
        return repositorioPostulacion.buscarPostulacionesPorCreadorNoAceptados(idUsuario);
    }

    @Override
    public List<Asistencia> buscarAsistenciasSinPostulantes(Long idUsuario) {
        List<Postulacion> postulaciones = repositorioPostulacion.buscarPostulacionesPorCreador(idUsuario);
        HashSet<Long> idAsistencia = new HashSet<Long>();

        for (Postulacion postulacion : postulaciones) {
            idAsistencia.add(postulacion.getAsistencia().getId());
        }

        if (idAsistencia.isEmpty()) {
            return repositorioAsistencia.buscarAsistenciaPorIdDelCliente(idUsuario);
        }

        return repositorioAsistencia.buscarAsistenciasPorIds(idAsistencia,idUsuario);
    }


    @Override
    public Asistencia actualizarAsistencia(DatosAsistencia datos) {

        Asistencia asistenciaAEditar = new Asistencia();
        Tipo_Turno turno = new Tipo_Turno();
        Tipo_Asistencia frecuencia = new Tipo_Asistencia();
        Zona zona = new Zona();

        asistenciaAEditar.setId(datos.getId());
        asistenciaAEditar.setNombre(datos.getNombre());
        asistenciaAEditar.setDescripcion(datos.getDescripcion());
        asistenciaAEditar.setCamaAdentro(datos.getCamaAdentro());
        asistenciaAEditar.setTarifa(datos.getTarifa());
        turno.setId(datos.getIdTurno());
        frecuencia.setId(datos.getIdFrecuencia());
        zona.setId(datos.getZona());

        asistenciaAEditar.setIdTurno(turno);
        asistenciaAEditar.setIdFrecuencia(frecuencia);
        asistenciaAEditar.setZona(zona);

        repositorioAsistencia.actualizar(asistenciaAEditar);
        return asistenciaAEditar;
    }

    @Override
    @ExceptionHandler
    public Asistencia buscarAsistenciaPorId(long id) throws Exception {

        Asistencia asistencia = repositorioAsistencia.buscarAsistenciaPorId(id);

        if(asistencia == null)
        {
            throw new Exception();
        }

        return asistencia;
    }


    @Override
    public List<Asistencia> buscarTodasLasAsistencias() {
        return repositorioAsistencia.buscarTodasLasAsistencias();
    }

    @Override
    public List<Asistencia> buscarAsistenciasMensuales() {
        return repositorioAsistencia.buscarAsistenciasMensuales();
    }

    @Override
    public List<Asistencia> buscarAsistenciasPorDia() {
        return repositorioAsistencia.buscarAsistenciasPorDia();
    }

    @Override
    public List<Asistencia> buscarAsistenciaPorIdDelCliente(Long idUsuario) { return repositorioAsistencia.buscarAsistenciaPorIdDelCliente(idUsuario); }

    @Override
    public void eliminarSolicitudDeEmpleo(Long id) { repositorioAsistencia.eliminarSolicitudDeEmpleo(id);}

    @Override
    public Asistencia buscarAsistenciaPorNombreEspecifico(String nombre) {
        return repositorioAsistencia.buscarAsistenciaPorNombreEspecifico(nombre);
    }

    //Metodos creados para mostrar empleos coordinados (que hayan aceptado al postulante)
    //Para asi, desde alli, ir a reseniar al profesional
    @Override
    public List<Postulacion> buscarEmpleosOfrecidosCoordinados(long id){
        return repositorioPostulacion.buscarEmpleosOfrecidosCoordinados(id);
    }

    @Override
    public List<Asistencia> buscarEmpleos(DatosFiltro datosFiltro) {
        return repositorioAsistencia.buscarEmpleos(datosFiltro);
    }
}

