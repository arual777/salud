package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioService {

    Servicio buscarServicio(String name, Long id);
    void guardar(Servicio servicio);
    Servicio buscar(String name);
    List<Servicio> buscarServicioPorTipo(String rol);

}
