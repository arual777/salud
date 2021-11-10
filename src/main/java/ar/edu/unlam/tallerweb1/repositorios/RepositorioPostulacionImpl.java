package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPostulacion")
public class RepositorioPostulacionImpl implements RepositorioPostulacion {

  private SessionFactory sessionFactory;

  @Autowired
  public RepositorioPostulacionImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void guardar(Postulacion nuevaPostulacion) {
    sessionFactory.getCurrentSession().save(nuevaPostulacion);
  }

  @Override
  public List<Postulacion> buscarPostulacionesPorIdUsuario(Long id) {
    final Session session = sessionFactory.getCurrentSession();
    return (List<Postulacion>) session.createCriteria(Postulacion.class)
            .add(Restrictions.eq("profesional.id", id)).list();
  }
  @Override
  public boolean verSiElUsuarioYaEstaPostulado(Long idAsistencia, Long idUsuario){
    final Session session = sessionFactory.getCurrentSession();

    return
            session.createCriteria(Postulacion.class)
                    .add(Restrictions.eq("asistencia.id", idAsistencia))
                    .add(Restrictions.eq("profesional.id", idUsuario)).uniqueResult() != null;
   }

  @Override
  public List<Postulacion> buscarPostulacionesPorId(Long id) {
    final Session session = sessionFactory.getCurrentSession();
    return (List<Postulacion>) session.createCriteria(Postulacion.class)
            .add(Restrictions.eq("id", id)).list();
  }

  @Override
  public void actualizarPostulacionAContratada(Postulacion postulacion) {
    sessionFactory.getCurrentSession().update(postulacion);
  }

  @Override
  public List<Postulacion> buscarPostulacionesPorCreador(Long usuarioId) {
    final Session session = sessionFactory.getCurrentSession();

    Criteria criteria = session.createCriteria(Postulacion.class, "a");
    criteria.createAlias("a.asistencia","asistencia");
    criteria.createAlias("asistencia.usuario","usuario");
       return (List<Postulacion>)     criteria.add(Restrictions.eq("usuario.id", usuarioId))
    .add(Restrictions.eq("Aceptado", false)).list();
  }

  @Override
  public List<Postulacion> buscarPostulaciones() {
    final Session session = sessionFactory.getCurrentSession();
    return (List<Postulacion>) session.createCriteria(Postulacion.class).list();
  }

  @Override
  public Postulacion buscarPostulacion(long idPostulacion) {
    final Session session = sessionFactory.getCurrentSession();
    return (Postulacion) session.createCriteria(Postulacion.class)
            .add(Restrictions.eq("id", idPostulacion)).uniqueResult();
  }

  @Override
  public Postulacion buscarPostulacionesPorId(long idProfesional) {
    final Session session = sessionFactory.getCurrentSession();
    return (Postulacion) session.createCriteria(Postulacion.class)
            .add(Restrictions.eq("profesional.id", idProfesional)).uniqueResult();
  }

  //Metodos creados para mostrar empleos coordinados (que hayan aceptado al postulante)
  //Para asi, desde alli, ir a reseniar al profesional

  @Override
  public List<Postulacion> buscarEmpleosOfrecidosCoordinados(long id){
    final Session session = sessionFactory.getCurrentSession();
    return (List<Postulacion>) session.createCriteria(Postulacion.class)
            .add(Restrictions.eq("Aceptado", true))
            .createCriteria("asistencia", "join_between_Postulacion_asistencia.id")
            .add(Restrictions.eq("usuario.id", id))
            .list();
  }
}