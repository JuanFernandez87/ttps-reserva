package ttps.clasesDAO;
import ttps.spring.model.Valoracion;

public interface ValoracionDAO extends GenericDAO<Valoracion>{
	public Valoracion recuperarValoracion(String valoracion);
}
