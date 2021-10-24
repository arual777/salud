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
    public PerfilProfesional registrarPerfil(String nombreCompleto, String email, String experiencia,
                                             String numTelefono, String fechaNacimiento) throws Exception{

        if (nombreCompleto.length() > 5 && email.length() > 5 && experiencia.length() > 10
                && numTelefono.length()>5) {

            PerfilProfesional nuevo = new PerfilProfesional();
            nuevo.setNombreCompleto(nombreCompleto);
            nuevo.setEmail(email);
            nuevo.setExperiencia(experiencia);
            nuevo.setNumeroTelefono(numTelefono);
            nuevo.setFechaNacimiento(fechaNacimiento);

            repositorioPerfilProfesional.guardar(nuevo);

            //obtener el usuario logueado
            // para esto tienen que agarrar el id del usuario en sesion y buscarlo en el repo
            // hacer un metodo que sea asignar perfil a usuario
            //fin

            return nuevo;
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public PerfilProfesional buscarCV(Long id) {

        PerfilProfesional perfilProfesional = repositorioPerfilProfesional.buscarCV(id);
        return perfilProfesional;
    }
}
