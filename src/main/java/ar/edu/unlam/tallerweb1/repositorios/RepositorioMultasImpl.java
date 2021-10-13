package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Multa;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("repositorioMultas")
public class RepositorioMultasImpl extends RepositorioMultas {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Multa> buscarPor(Usuario usuario){
		return sessionFactory.getCurrentSession().createCriteria(Multa.class)
				.add(Restrictions.eq("infractor", usuario))
				.list();
	}

	@Override
	public List<Multa> buscarPorMail(String mail){
		return sessionFactory.getCurrentSession().createCriteria(Multa.class)
				.createAlias("infractor", "i")
				.add(Restrictions.like("i.email", "%" + mail + "%"))
				.list();
	}
}
