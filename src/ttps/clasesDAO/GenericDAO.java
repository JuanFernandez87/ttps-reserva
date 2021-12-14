package ttps.clasesDAO;

import java.util.List;

public interface GenericDAO<T> {
	public T actualizar(T entity);
	public void borrar(T entity);
	public T borrar(Integer id);
	public boolean existe(Integer id);
	public T persistir(T entity);
	public T recuperar(Integer id);
	public List<T> recuperarTodos(String column);
	public boolean isExist(T entity);
}