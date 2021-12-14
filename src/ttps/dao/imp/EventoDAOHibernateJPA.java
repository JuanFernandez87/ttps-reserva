package ttps.dao.imp;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.clasesDAO.EventoDAO;
import ttps.spring.model.Evento;
@Repository
public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {

	public EventoDAOHibernateJPA() {
		super(Evento.class);
	}

	@Override
	public Evento recuperarEvento(String evento) {
		Query consulta = EMF.getEMF().createEntityManager().
		createQuery("select p from Evento p where p.nombre =?");
		consulta.setParameter(1, evento);
		Evento resultado = (Evento)consulta.getSingleResult();
		return resultado;
	}

}
