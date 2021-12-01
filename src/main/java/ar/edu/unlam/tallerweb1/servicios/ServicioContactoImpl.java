package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosContacto;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("servicioContacto")
@Transactional
public class ServicioContactoImpl implements ServicioContacto{

    private RepositorioAsistencia repositorioAsistencia;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPostulacion repositorioPostulacion;
    private RepositorioPerfilProfesional repositorioPerfilProfesional;
    private RepositorioContacto repositorioContacto;

    @Autowired
    public ServicioContactoImpl(RepositorioAsistencia repositorioAsistencia, RepositorioUsuario repositorioUsuario, RepositorioPostulacion repositorioPostulacion, RepositorioPerfilProfesional repositorioPerfilProfesional, RepositorioContacto repositorioContacto){
        this.repositorioAsistencia = repositorioAsistencia;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPostulacion = repositorioPostulacion;
        this.repositorioPerfilProfesional = repositorioPerfilProfesional;
        this.repositorioContacto = repositorioContacto;
    }

    @Override
    public Contacto GeneracionUsuarioContacto(DatosContacto datosContacto) throws Exception {
        Contacto nuevoContacto = new Contacto();

        nuevoContacto.setEmail(datosContacto.getEmail());
        nuevoContacto.setName(datosContacto.getName());
        nuevoContacto.setSubject(datosContacto.getSubject());

        repositorioContacto.GeneracionUsuarioContacto(nuevoContacto);
        return nuevoContacto;
    }
}

