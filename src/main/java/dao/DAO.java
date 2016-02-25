package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Model;
import utils.EntityManagerUtils;

public class DAO<T extends Model<?>> {

	private Class<T> klazz;
	
	public DAO(Class<T> klazz) {
		this.klazz = klazz;
	}
	
	public void create(T entity) {
		EntityManager em = EntityManagerUtils.criarEntityManager();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public T find(Object id) {
		return EntityManagerUtils.criarEntityManager().find(klazz, id);
	}
	
	public List<T> findAll() {
		Query query = EntityManagerUtils
				.criarEntityManager()
				.createQuery("from " + klazz.getSimpleName());
		return query.getResultList();
	}
	
	public void update(T entity) {
		EntityManager em = EntityManagerUtils.criarEntityManager();
		em.merge(entity);
		em.getTransaction().commit();
	}
	
	public void delete(T entity) {
		EntityManager em = EntityManagerUtils.criarEntityManager();
		em.remove(entity);
		em.getTransaction().commit();
	}
	
}
