package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;

import java.util.List;

public interface RepositorioPerfilProfesional {
    void guardar(PerfilProfesional perfilProfesional);

    PerfilProfesional buscarCV(Long id);

    List<PerfilProfesional> buscarTodos();

    void editarPerfilProfesional(PerfilProfesional perfilProfesionalAEditar);
}
