package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Contacto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioContacto {

    void GeneracionUsuarioContacto (Contacto contacto) throws Exception;

}
