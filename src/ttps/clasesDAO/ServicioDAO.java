package ttps.clasesDAO;
import ttps.spring.model.Servicio;

public interface ServicioDAO extends GenericDAO<Servicio>{
	public Servicio recuperarServicio(String servicio);
}
