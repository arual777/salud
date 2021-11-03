package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosResenia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioResenia {
    void registrarResenia(DatosResenia datos);

    List<Usuario> traerListaProfesionales(long idRol);

    Usuario buscarUsuario(long id);
}
