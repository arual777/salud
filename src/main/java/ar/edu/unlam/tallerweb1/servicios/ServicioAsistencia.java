package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;

public interface ServicioAsistencia {

    Asistencia crearNuevoTipoDeAsistencia(String name, String descripcion);


    Asistencia crearServicio(String name);
}
