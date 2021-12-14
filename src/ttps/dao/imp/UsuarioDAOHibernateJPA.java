package ttps.dao.imp;

import javax.persistence.Query;
import ttps.clasesDAO.UsuarioDAO;
import ttps.spring.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	@Override
	public Usuario recuperarUsuario(String usuario) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select usuario "
																		+ "from Usuario usuario "
																		+ "where usuario.nombre =?");
		consulta.setParameter(1, usuario);
		Usuario resultado = (Usuario)consulta.getSingleResult();
		return resultado;
	}

	public boolean isExist(String user) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select u from usuarios u where usuarios.user = '"+user+"'");
		System.out.println("Usuario " + consulta);
		if (consulta != null) {
			return true;
		}
		return false;
	}		
}	
