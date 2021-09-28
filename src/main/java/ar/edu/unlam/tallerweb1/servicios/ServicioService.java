package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Servicio;

import java.util.List;

public interface ServicioService {
    Servicio crearServicio(String name);

    List<Servicio> buscarTodos ();
}
