package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Turno;
import ar.edu.unlam.tallerweb1.modelo.Zona;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioAsistencia")
@Transactional
public class ServicioAsistenciaImpl implements ServicioAsistencia{

    private RepositorioAsistencia repositorioAsistencia;

    @Autowired
    public ServicioAsistenciaImpl(RepositorioAsistencia repositorioAsistencia){
        this.repositorioAsistencia = repositorioAsistencia;
    }

    @Override
    public Asistencia crearServicio(DatosAsistencia datos) {

        Asistencia nuevo = new Asistencia();

        Tipo_Turno turno = new Tipo_Turno();
        Tipo_Asistencia frecuencia = new Tipo_Asistencia();
        Zona zona = new Zona();

        nuevo.setNombre(datos.getNombre());
        nuevo.setDescripcion(datos.getDescripcion());
        nuevo.setCamaAdentro(datos.getCamaAdentro());
        nuevo.setTarifa(datos.getTarifa());
        turno.setId(datos.getIdTurno());
        frecuencia.setId(datos.getIdFrecuencia());
        zona.setId(datos.getZona());

        nuevo.setIdTurno(turno);
        nuevo.setIdFrecuencia(frecuencia);
        nuevo.setZona(zona);

        repositorioAsistencia.guardar(nuevo);

        return nuevo;
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

        repositorioAsistencia.guardar(asistenciaAEditar);
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

}

