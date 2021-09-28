package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Agregado para que no de error IntelliJ
public interface RepositorioService {

    Servicio buscarServicio(String name, Long id);
    void guardar(Servicio servicio);
    Servicio buscar(String name);
    List<Servicio> buscarTodos ();
    List<Servicio> buscarServicioPorTipo(String rol);

}
