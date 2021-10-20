package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;

import java.util.List;

public interface ServicioPerfilProfesional {


    PerfilProfesional registrarPerfil(String nombreCompleto, String email, String experiencia, String numTelefono, String fechaNacimiento) throws Exception;

    PerfilProfesional buscarCV(Long id);

    List<PerfilProfesional> buscarTodos();
}
