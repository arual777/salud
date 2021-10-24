package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostulacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioAsistencia")
@Transactional
public class ServicioAsistenciaImpl implements ServicioAsistencia{

    private RepositorioAsistencia repositorioAsistencia;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPostulacion repositorioPostulacion;

    @Autowired
    public ServicioAsistenciaImpl(RepositorioAsistencia repositorioAsistencia, RepositorioUsuario repositorioUsuario, RepositorioPostulacion repositorioPostulacion){
        this.repositorioAsistencia = repositorioAsistencia;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPostulacion = repositorioPostulacion;
    }

    @Override
    public void crearPostulacion(DatosPostulacion datosPostulacion) throws Exception {
        if(repositorioPostulacion.verSiElUsuarioYaEstaPostulado(datosPostulacion.getIdAsistencia(), datosPostulacion.getIdUsuario())){
            throw new Exception("El usuario ya se postuló");
        }

        Postulacion nuevaPostulacion = new Postulacion();
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

        repositorioAsistencia.guardar(nuevaAsistencia);

        return nuevaAsistencia;
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
    public List<Asistencia> buscarTodosLosEmpleos() { return repositorioAsistencia.buscarTodosLosEmpleos(); }

    @Override
    public void eliminarSolicitudDeEmpleo(Long id) { repositorioAsistencia.eliminarSolicitudDeEmpleo(id);}

    @Override
    public Asistencia buscarAsistenciaPorNombreEspecifico(String nombre) {
        return repositorioAsistencia.buscarAsistenciaPorNombreEspecifico(nombre);
    }
}

