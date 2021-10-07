package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Turno;
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

        nuevo.setNombre(datos.getNombre());
        nuevo.setTipo(datos.getTipo());
        turno.setId(datos.getIdTurno());
        nuevo.setIdTurno(turno);
        repositorioAsistencia.guardar(nuevo);
    return nuevo;
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
}

