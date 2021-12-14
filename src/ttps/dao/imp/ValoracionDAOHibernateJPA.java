package ttps.dao.imp;

import javax.persistence.Query;

import ttps.clasesDAO.ValoracionDAO;
import ttps.spring.model.Valoracion;
import org.springframework.stereotype.Repository;

@Repository
public class ValoracionDAOHibernateJPA extends GenericDAOHibernateJPA<Valoracion> implements ValoracionDAO {
	
	public ValoracionDAOHibernateJPA() {
		super(Valoracion.class);
	}

	@Override
	public Valoracion recuperarValoracion(String valoracion) {
		Query consulta = EMF.getEMF().createEntityManager().
		createQuery("select p from Valoracion p where p.nombre =?");
		consulta.setParameter(1, valoracion);
		Valoracion resultado = (Valoracion)consulta.getSingleResult();
		return resultado;
	}
}
