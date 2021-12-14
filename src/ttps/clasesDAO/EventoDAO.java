package ttps.clasesDAO;

import ttps.spring.model.Evento;

public interface EventoDAO extends GenericDAO<Evento> {
	public Evento recuperarEvento(String evento);
}
