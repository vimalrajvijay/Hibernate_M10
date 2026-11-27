package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employee e1 = new Employee();
		e1.setId(104);
		e1.setName("MNO");
		e1.setSalary(12000);
		try {
			et.begin();
			em.persist(e1);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
	}
}
