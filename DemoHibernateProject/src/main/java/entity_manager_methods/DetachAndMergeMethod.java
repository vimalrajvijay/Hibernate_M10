package entity_manager_methods;

import demo.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DetachAndMergeMethod {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e1 = em.find(Employee.class, 102); // Persistent State
		
		try {
			et.begin();
			em.detach(e1);// Detached State
			e1.setSalary(25000);
			em.merge(e1); // Persistent State
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
		
		System.out.println(e1);
	}

}
