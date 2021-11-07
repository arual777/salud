package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.modelo.Resenia;
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
    public void guardarResenia(Resenia resenia) {
        sessionFactory.getCurrentSession().save(resenia);
    }

    @Override
    public void guardarReseniaACliente(ReseniaACliente reseniaACliente)  {
        sessionFactory.getCurrentSession().save(reseniaACliente);
    }

    @Override
    public List<Resenia> buscarReseniaPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Resenia>) session.createCriteria(Resenia.class)
                .add(Restrictions.eq("id", id)).list();
    }

    @Override
    public List<Resenia> buscarReseniasPorIdProfesional(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Resenia>) session.createCriteria(Resenia.class)
                .add(Restrictions.eq("idUsuarioProfesional.id", id)).list();
    }

    @Override
    public List<ReseniaACliente> buscarReseniasAClientePorIdCliente(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<ReseniaACliente>) session.createCriteria(ReseniaACliente.class)
                .add(Restrictions.eq("idUsuarioCliente.id", id)).list();
    }
}
