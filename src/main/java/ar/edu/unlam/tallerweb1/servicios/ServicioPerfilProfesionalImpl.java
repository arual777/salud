package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistroProfesional;
import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPerfilProfesional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("servicioPerfilProfesional")
@Transactional
public class ServicioPerfilProfesionalImpl implements ServicioPerfilProfesional {

    private RepositorioPerfilProfesional repositorioPerfilProfesional;

    @Autowired
    public ServicioPerfilProfesionalImpl (RepositorioPerfilProfesional repositorioPerfilProfesional){this.repositorioPerfilProfesional=repositorioPerfilProfesional;}

    @Override
    public PerfilProfesional registrarPerfil(String nombreCompleto, String email, String experiencia,
                                             String numTelefono, String fechaNacimiento, long idUsuario) throws Exception{

        if (nombreCompleto.length() > 5 && email.length() > 5 && experiencia.length() > 10
                && numTelefono.length()>5) {

            PerfilProfesional nuevo = new PerfilProfesional();
            nuevo.setNombreCompleto(nombreCompleto);
            nuevo.setEmail(email);
            nuevo.setExperiencia(experiencia);
            nuevo.setNumeroTelefono(numTelefono);
            nuevo.setFechaNacimiento(fechaNacimiento);
            Usuario usuario = repositorioPerfilProfesional.obtenerIdUsuario(idUsuario);
            nuevo.setIdUsuario(usuario);

            repositorioPerfilProfesional.guardar(nuevo);

            return nuevo;
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public PerfilProfesional editarPerfil(DatosRegistroProfesional datos){

        PerfilProfesional perfilProfesionalAEditar = new PerfilProfesional();
        perfilProfesionalAEditar.setId(datos.getId());
        perfilProfesionalAEditar.setNombreCompleto(datos.getNombreCompleto());
        perfilProfesionalAEditar.setEmail(datos.getEmail());
        perfilProfesionalAEditar.setExperiencia(datos.getExperiencia());
        perfilProfesionalAEditar.setNumeroTelefono(datos.getNumeroTelefono());
        perfilProfesionalAEditar.setFechaNacimiento(datos.getFechaNacimiento());

        Usuario usuario = repositorioPerfilProfesional.obtenerIdUsuario(datos.getIdUsuario());
        perfilProfesionalAEditar.setIdUsuario(usuario);

        repositorioPerfilProfesional.editarPerfilProfesional(perfilProfesionalAEditar);
        return perfilProfesionalAEditar;
    }

    @Override
    public PerfilProfesional buscarCV(Long id) {

        PerfilProfesional perfilProfesional = repositorioPerfilProfesional.buscarCV(id);
        return perfilProfesional;
    }

    @Override
    public PerfilProfesional buscarCVPorIdUsuario(Long id) {

        PerfilProfesional perfilProfesional = repositorioPerfilProfesional.buscarCVPorIdUsuario(id);
        return perfilProfesional;
    }

    @Override
    public List <PerfilProfesional> buscarTodos(){
        return repositorioPerfilProfesional.buscarTodos();

    }
}
