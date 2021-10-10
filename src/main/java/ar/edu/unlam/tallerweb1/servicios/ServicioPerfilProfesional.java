package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;

public interface ServicioPerfilProfesional {


    PerfilProfesional registrarPerfil(String nombreCompleto, String email, String experiencia, String numTelefono);
}
