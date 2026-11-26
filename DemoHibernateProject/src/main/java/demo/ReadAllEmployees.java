package demo;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ReadAllEmployees {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select e from Employee e";
		
		Query query = em.createQuery(jpql);
		
		List<Employee> employees = query.getResultList();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
