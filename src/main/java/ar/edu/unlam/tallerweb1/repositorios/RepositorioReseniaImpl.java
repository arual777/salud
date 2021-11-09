package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.ReseniaAProfesional;
import ar.edu.unlam.tallerweb1.modelo.ReseniaACliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("repositorioResenia")
public class RepositorioReseniaImpl implements RepositorioResenia{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioReseniaImpl(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}


    @Override
    public void guardarResenia(ReseniaAProfesional reseniaAProfesional) {
        sessionFactory.getCurrentSession().save(reseniaAProfesional);
    }

    @Override
    public void guardarReseniaACliente(ReseniaACliente reseniaACliente)  {
        sessionFactory.getCurrentSession().save(reseniaACliente);
    }

    @Override
    public List<ReseniaAProfesional> buscarReseniaPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<ReseniaAProfesional>) session.createCriteria(ReseniaAProfesional.class)
                .add(Restrictions.eq("id", id)).list();
    }

    @Override
    public List<ReseniaAProfesional> buscarReseniasPorIdProfesional(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<ReseniaAProfesional>) session.createCriteria(ReseniaAProfesional.class)
                .add(Restrictions.eq("idUsuarioProfesional.id", id)).list();
    }

    @Override
    public List<ReseniaACliente> buscarReseniasAClientePorIdCliente(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<ReseniaACliente>) session.createCriteria(ReseniaACliente.class)
                .add(Restrictions.eq("idUsuarioCliente.id", id)).list();
    }

    @Override
    public List<ReseniaAProfesional> buscarReseniaPorClienteYProfesional(long idCliente, long idProfesional){
        final Session session = sessionFactory.getCurrentSession();
        return (List<ReseniaAProfesional>) session.createCriteria(ReseniaAProfesional.class)
                .add(Restrictions.eq("idUsuarioCliente.id", idCliente))
                .add(Restrictions.eq("idUsuarioProfesional.id", idProfesional)).list();
    }

    @Override
    public List<ReseniaACliente> buscarReseniaAClientePorClienteYProfesional(long idCliente, long idProfesional){
        final Session session = sessionFactory.getCurrentSession();
        return (List<ReseniaACliente>) session.createCriteria(ReseniaACliente.class)
                .add(Restrictions.eq("idUsuarioCliente.id", idCliente))
                .add(Restrictions.eq("idUsuarioProfesional.id", idProfesional)).list();
    }
}
