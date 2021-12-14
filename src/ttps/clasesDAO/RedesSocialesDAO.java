package ttps.clasesDAO;
import ttps.spring.model.RedesSociales;

public interface RedesSocialesDAO extends GenericDAO<RedesSociales> {
	public RedesSociales recuperarRedesSociales(String redes);
}
