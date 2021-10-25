package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Resenia;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("repositorioResenia")
public class RepositorioReseniaImpl implements RepositorioResenia{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioReseniaImpl(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}


    @Override
    public void guardarResenia(Resenia resenia) {
        sessionFactory.getCurrentSession().save(resenia);
    }
}
