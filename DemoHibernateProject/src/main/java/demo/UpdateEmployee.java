package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e1 = em.find(Employee.class, 101);
		
		double existingSal = e1.getSalary();
		double updatedSal = existingSal+(existingSal*0.1);
		e1.setSalary(updatedSal);
		
		try {
			et.begin();
			em.merge(e1);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
	}
}
