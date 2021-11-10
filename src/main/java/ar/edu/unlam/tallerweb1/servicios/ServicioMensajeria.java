package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosMensajeria;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;

import java.util.List;

public interface ServicioMensajeria {

   void crearPregunta(DatosMensajeria datosMensajeria);

    List<Mensaje> buscarPreguntasPorUsuario(Long idUsuario);

    void responder(DatosMensajeria datosMensajeria);
}


