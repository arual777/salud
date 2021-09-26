package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioAsistencia")
public class RepositoriAsistenciaImpl implements RepositorioAsistencia{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositoriAsistenciaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Asistencia> buscarTodasLasAsistencias() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Asistencia>) session.createCriteria(Asistencia.class)
                .list();
    }


    @Override
    public List<Asistencia> buscarAsistenciaParaLaNoche() {
        return null;
    }
}
