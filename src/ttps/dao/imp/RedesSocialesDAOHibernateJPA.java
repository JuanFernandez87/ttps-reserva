package ttps.dao.imp;

import javax.persistence.Query;

import ttps.clasesDAO.RedesSocialesDAO;
import ttps.spring.model.RedesSociales;
import org.springframework.stereotype.Repository;

@Repository
public class RedesSocialesDAOHibernateJPA extends GenericDAOHibernateJPA<RedesSociales> implements RedesSocialesDAO{

	public RedesSocialesDAOHibernateJPA() {
		super(RedesSociales.class);
	}

	@Override
	public RedesSociales recuperarRedesSociales(String redes) {
		Query consulta = EMF.getEMF().createEntityManager().
		createQuery("select p from RedesSociales p where p.nombre =?");
		consulta.setParameter(1, redes);
		RedesSociales resultado = (RedesSociales)consulta.getSingleResult();
		return resultado;
	}
}
