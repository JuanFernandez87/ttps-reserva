package conexionBD;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
	private static final String PERSISTENCE_UNITE_NAME = "reserva_servicios";
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory conectar() {
		if (emf == null) {
			emf=Persistence.createEntityManagerFactory(PERSISTENCE_UNITE_NAME);
		}
		return emf;
	}
	
	public static void cerrar() {
		if (emf != null) {
			emf.close();
		}
	}
}
