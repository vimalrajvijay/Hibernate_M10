package dirty_checking;

import demo.Employee;
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
		
		Employee e1 = em.find(Employee.class, 102);
		
		try {
			et.begin();
			e1.setSalary(20000);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
	}
}
