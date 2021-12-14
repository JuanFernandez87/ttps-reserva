package ttps.dao.imp;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import ttps.clasesDAO.ReservaDAO;
import ttps.spring.model.Reserva;

@Repository
public class ReservaDAOHibernateJPA extends GenericDAOHibernateJPA<Reserva> implements ReservaDAO {

	public ReservaDAOHibernateJPA() {
		super(Reserva.class);
	}

	@Override
	public Reserva recuperarReserva(String reserva) {
		Query consulta = EMF.getEMF().createEntityManager().
		createQuery("select p from Reserva p where p.nombre =?");
		consulta.setParameter(1, reserva);
		Reserva resultado = (Reserva)consulta.getSingleResult();
		return resultado;
	}	
	
}
