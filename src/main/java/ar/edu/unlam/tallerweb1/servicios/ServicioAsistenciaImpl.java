package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("servicioAsistencia")
    @Transactional
    public class ServicioAsistenciaImpl implements ServicioAsistencia{

        private RepositorioAsistencia repositorioAsistencia;

        @Autowired
        public ServicioAsistenciaImpl(RepositorioAsistencia repositorioAsistencia){
            this.repositorioAsistencia = repositorioAsistencia;
        }

    @Override
    public Asistencia crearNuevoTipoDeAsistencia(String name, String descripcion) {
        return null;
    }

    @Override
        public Asistencia crearServicio(String name) {

            Asistencia nuevo = new Asistencia();
            nuevo.setNombre(name);
            repositorioAsistencia.guardar(nuevo);
            return nuevo;
        }
    }

