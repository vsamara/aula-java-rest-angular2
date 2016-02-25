package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerUtils {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void criarConexao() {
		emf = Persistence.createEntityManagerFactory("rest");
	}

	public static EntityManager criarEntityManager() {
		em = (em == null || !em.isOpen()) ? em = emf.createEntityManager() : em;
		EntityTransaction et = em.getTransaction();
		if(!et.isActive()) {
			et.begin();
		}
		
		return em; 
	}

	public static void fechaConexao() {
		if(em != null && em.isOpen()) {
			em.close();
		}
		emf.close();
	}
	
}
