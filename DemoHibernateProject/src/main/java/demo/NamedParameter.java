package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NamedParameter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();

		String jpql = "select e from Employee e where e.id=:emp_id";

		Query query = em.createQuery(jpql);

		query.setParameter("emp_id", 102);

		Employee employee = (Employee) query.getSingleResult();

		System.out.println(employee);
	}
}
