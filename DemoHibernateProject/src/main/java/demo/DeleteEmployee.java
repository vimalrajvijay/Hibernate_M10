package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e1 = em.find(Employee.class, 101);
		
		try {
			et.begin();
			em.remove(e1);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
	}
}
