package entity_manager_methods;

import demo.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RefreshMethod {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
		Employee e1 = em.find(Employee.class, 102);
		
		e1.setSalary(30000);
		System.out.println(e1);
		
		em.refresh(e1);
		System.out.println(e1);
	}

}
