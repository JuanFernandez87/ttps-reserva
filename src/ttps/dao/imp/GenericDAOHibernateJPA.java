package ttps.dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import ttps.clasesDAO.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass = clase;
	}
	
	@Override
	public T persistir(T entity) {
		 this.getEntityManager().persist(entity);
		 
		 return entity;
	}  
	
	@Override
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
    }
	@Override
	public void borrar(T entity) {
		EntityManager em = this.getEntityManager();
		em.remove(em.merge(entity));
		}

	@Override
	public T borrar(Integer id) {
		EntityManager em = this.getEntityManager();
		T entity = em.find(getPersistentClass(), id);
		if (entity != null) {
			em.remove(entity);
		}
		return entity;	
		}
	
	@Override
	public List<T> recuperarTodos(String columnOrder) {
		EntityManager em = this.getEntityManager();
		 javax.persistence.Query consulta = em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e order by e." + columnOrder);
		 List<T> resultado = (List<T>)consulta.getResultList();
		 em.close();
		 return resultado;
	}

	@Override
	public boolean existe(Integer id) {
		EntityManager em = this.getEntityManager();
		T entity = em.find(getPersistentClass(), id);
		if (entity != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}

	@Override
	public T recuperar(Integer id) {
		EntityManager em = this.getEntityManager();
		T entity = em.find(getPersistentClass(), id);
		em.close();
		return entity;
	}
	
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	public boolean isExist(T entity) {
		EntityManager em = this.getEntityManager();
		if(em.contains(entity)) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}	

}	