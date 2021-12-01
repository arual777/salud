package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosContacto;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Contacto;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;

import java.util.List;

public interface ServicioContacto {

   Contacto GeneracionUsuarioContacto (DatosContacto datosContacto) throws Exception;

}
