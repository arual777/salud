package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProfesional;
import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPerfilProfesional {


    PerfilProfesional registrarPerfil(String nombreCompleto, String email, String experiencia, String numTelefono, String fechaNacimiento, long idUsuario) throws Exception;

    PerfilProfesional editarPerfil(DatosRegistroProfesional datos);

    PerfilProfesional buscarCV(Long id);

    PerfilProfesional buscarCVPorIdUsuario(Long id);

    List<PerfilProfesional> buscarTodos();
}
