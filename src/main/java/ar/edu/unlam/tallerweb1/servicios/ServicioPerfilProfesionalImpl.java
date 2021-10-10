package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPerfilProfesional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioPerfilProfesional")
@Transactional
public class ServicioPerfilProfesionalImpl implements ServicioPerfilProfesional {

    private RepositorioPerfilProfesional repositorioPerfilProfesional;

    @Autowired
    public ServicioPerfilProfesionalImpl (RepositorioPerfilProfesional repositorioPerfilProfesional){this.repositorioPerfilProfesional=repositorioPerfilProfesional;}

    @Override
    public PerfilProfesional registrarPerfil(String nombreCompleto, String email, String experiencia, String numTelefono){

        PerfilProfesional nuevo = new PerfilProfesional();
        nuevo.setNombreCompleto(nombreCompleto);
        nuevo.setEmail(email);
        nuevo.setExperiencia(experiencia);
        nuevo.setNumeroTelefono(numTelefono);

        repositorioPerfilProfesional.guardar(nuevo);

        return nuevo;

    }
}
