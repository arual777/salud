package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

}
