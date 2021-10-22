package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asistencia;
import ar.edu.unlam.tallerweb1.modelo.PerfilProfesional;
import ar.edu.unlam.tallerweb1.modelo.Postulacion;
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
  public RepositorioPostulacionImpl(SessionFactory sessionFactory){
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void guardar(Postulacion nuevaPostulacion){
    sessionFactory.getCurrentSession().save(nuevaPostulacion);
  }

  @Override
  public List<Postulacion> buscarPostulacionesPorIdUsuario(Long id) {
    final Session session = sessionFactory.getCurrentSession();
    return (List<Postulacion>) session.createCriteria(Postulacion.class)
            .add(Restrictions.eq("profesional.id", id)).list();
  }
}
