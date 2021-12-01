package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.controladores.DatosContacto;
import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Contacto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioContacto")
public class RepositorioContactoImpl implements RepositorioContacto{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioContactoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void GeneracionUsuarioContacto(Contacto contacto) throws Exception {
        sessionFactory.getCurrentSession().save(contacto) ;

    }

}