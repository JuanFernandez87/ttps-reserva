package ttps.dao.imp;

import javax.persistence.Query;

import ttps.clasesDAO.ServicioDAO;
import ttps.spring.model.Servicio;
import org.springframework.stereotype.Repository;

@Repository
public class ServicioDAOHibernateJPA extends GenericDAOHibernateJPA<Servicio> implements ServicioDAO {

	public ServicioDAOHibernateJPA() {
		super(Servicio.class);
	}

	@Override
	public Servicio recuperarServicio(String servicio) {
		Query consulta = EMF.getEMF().createEntityManager().
		createQuery("select p from Servicio p where p.nombre =?");
		consulta.setParameter(1, servicio);
		Servicio resultado = (Servicio)consulta.getSingleResult();
		return resultado;
	}	
	
}
