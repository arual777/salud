package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioService")
public class RepositorioServiceImpl implements RepositorioService {
    @Override
    public Servicio buscarServicio(String name, Long id) {
        return null;
    }

    @Override
    public void guardar(Servicio servicio) {

    }

    @Override
    public Servicio buscar(String name) {
        return null;
    }

    @Override
    public List<Servicio> buscarTodos() {
        return null;
    }

    @Override
    public List<Servicio> buscarServicioPorTipo(String rol) {
        return null;
    }
}
