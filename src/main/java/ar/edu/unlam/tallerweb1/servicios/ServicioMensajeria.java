package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosMensajeria;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;

import java.util.List;

public interface ServicioMensajeria {

   Mensaje crearPregunta(DatosMensajeria datosMensajeria);

    List<Mensaje> buscarPreguntasPorUsuario(Long idUsuario);

    void responder(DatosMensajeria datosMensajeria);


    List<Mensaje> buscarPreguntasPorUsuarioRespondidas(Long idUsuario);
}


