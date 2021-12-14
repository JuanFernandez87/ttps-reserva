package ttps.clasesDAO;
import ttps.spring.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	public Usuario recuperarUsuario(String usuario);
	public boolean isExist(String user);
}
