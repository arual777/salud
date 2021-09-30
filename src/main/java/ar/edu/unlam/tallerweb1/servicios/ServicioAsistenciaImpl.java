package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
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
    public Asistencia crearServicio(String name) {

        Asistencia nuevo = new Asistencia();
        nuevo.setNombre(name);
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
}

