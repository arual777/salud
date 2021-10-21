package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.Tipo_Turno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
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
    public List<Asistencia> buscarAsistenciasMensuales() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Asistencia>) session.createCriteria(Asistencia.class)
                .add(Restrictions.eq("tipo", "Mensual"))
                .list();
    }

    @Override
    public List<Asistencia> buscarAsistenciasPorDia(){
        final Session session = sessionFactory.getCurrentSession();
        return (List<Asistencia>) session.createCriteria(Asistencia.class)
                .add(Restrictions.eq("tipo", "PorDia"))
                .list();
    }


    @Override
    public List<Asistencia> buscarAsistenciaParaLaNoche(String tipo_turno) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Asistencia>) session.createCriteria(Asistencia.class)
                .add(Restrictions.eq("idTurno", tipo_turno))
                .list();
    }

    @Override
    public List<Asistencia> buscarAsistenciaPorNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Asistencia>) session.createCriteria(Asistencia.class)
                .add(Restrictions.like("nombre", nombre, MatchMode.ANYWHERE))
                .list();
    }

    @Override
    public Asistencia buscarAsistenciaPorId(long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Asistencia) session.createCriteria(Asistencia.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void guardar(Asistencia asistencia) {
        sessionFactory.getCurrentSession().save(asistencia) ;
    }

    @Override
    public void actualizar(Asistencia asistencia) {
        sessionFactory.getCurrentSession().update(asistencia) ;
    }


    @Override
    public List<Asistencia> buscarTodosLosEmpleos(){
        final Session session = sessionFactory.getCurrentSession();
        return (List<Asistencia>) session.createCriteria(Asistencia.class)
                .list();
    }

    @Override
    public void eliminarSolicitudDeEmpleo(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        Asistencia asistenciaPorEliminar = new Asistencia();
        asistenciaPorEliminar = buscarAsistenciaPorId(id);
        session.delete(asistenciaPorEliminar);
    }

    @Override
    public Asistencia buscarAsistenciaPorNombreEspecifico(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return (Asistencia) session.createCriteria(Asistencia.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();
    }

}
