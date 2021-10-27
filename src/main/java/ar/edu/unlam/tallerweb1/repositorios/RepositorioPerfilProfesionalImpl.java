package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository("repositorioPerfilProfesional")
public class RepositorioPerfilProfesionalImpl implements RepositorioPerfilProfesional {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPerfilProfesionalImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(PerfilProfesional perfilProfesional){
        sessionFactory.getCurrentSession().save(perfilProfesional);
    }

    @Override
    public PerfilProfesional buscarCV(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (PerfilProfesional) session.createCriteria(PerfilProfesional.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public PerfilProfesional buscarCVPorIdUsuario(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (PerfilProfesional) session.createCriteria(PerfilProfesional.class)
                .add(Restrictions.eq("idUsuario.id", id)).uniqueResult();
    }

    @Override
    public List<PerfilProfesional> buscarTodos() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<PerfilProfesional>) session.createCriteria(PerfilProfesional.class)
                .list();
    }

    @Override
    public void editarPerfilProfesional(PerfilProfesional perfilProfesional){
    sessionFactory.getCurrentSession().update(perfilProfesional) ;
    }

    @Override
    public Usuario obtenerIdUsuario(long id) {
        return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
}
