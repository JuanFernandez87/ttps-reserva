package ttps.dao.imp;

import ttps.clasesDAO.*;

public class DaoFactory {
	public static EventoDAO getEventoDAO() {
		return new EventoDAOHibernateJPA();
	}

	public static RedesSocialesDAO getRedesSocialesDAO() {
		return new RedesSocialesDAOHibernateJPA();
	}
	
	public static ReservaDAO getReservaDAO() {
		return new ReservaDAOHibernateJPA();
	}
	
	public static ServicioDAO getServicioDAO() {
		return new ServicioDAOHibernateJPA();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}
	
	public static ValoracionDAO getValoracionDAO() {
		return new ValoracionDAOHibernateJPA();
	}
}