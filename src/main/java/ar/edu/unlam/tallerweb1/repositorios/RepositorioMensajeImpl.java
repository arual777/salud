package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Mensaje;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioMensaje")
public class RepositorioMensajeImpl implements RepositorioMensaje{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioMensajeImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void crearPregunta(Mensaje mensaje) {
        sessionFactory.getCurrentSession().save(mensaje) ;
    }

    @Override
    public Mensaje buscarMensajePorId(long idMensaje) {
        final Session session = sessionFactory.getCurrentSession();
        return (Mensaje) session.createCriteria(Mensaje.class)
                .add(Restrictions.eq("idMensaje", idMensaje))
                .uniqueResult();
    }

    @Override
    public List<Mensaje> buscarLosMensajesPorIdUsuario(Long idUsuario){
        final Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(Mensaje.class, "m");
        criteria.createAlias("m.asistencia","asistencia");
        criteria.createAlias("asistencia.usuario","usuario");
        return (List<Mensaje>)criteria.add(Restrictions.eq("usuario.id", idUsuario)).list();

    }

    @Override
    public void actualizar(Mensaje mensaje) {
        sessionFactory.getCurrentSession().update(mensaje);
    }
}
