package ttps.dao.imp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("reserva_servicios");
	
	public static EntityManagerFactory getEMF() {
		return em;
	}
}
