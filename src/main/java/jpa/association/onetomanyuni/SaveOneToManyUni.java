package jpa.association.onetomanyuni;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveOneToManyUni {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToManyUni");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		Department d = new Department();
		d.setName("Trainer");
		d.setLoc("Jspider, BTM");
		Employee e1 = new Employee();
		e1.setName("Keshav");
		e1.setSal(100000);
		e1.setDegn("Head");
		Employee e2 = new Employee();
		e2.setName("Pavan");
		e2.setSal(90000);
		e2.setDegn("Java");
		Employee e3 = new Employee();
		e3.setName("Guru");
		e3.setSal(50000);
		e3.setDegn("Advanced Java");
		Employee e4 = new Employee();
		e4.setName("Anugraha");
		e4.setSal(50000);
		e4.setDegn("Spring Boot");
		List<Employee> li = Arrays.asList(e1, e2, e3, e4);
		d.setEmp(li);
		em.persist(d);

		Department d1 = new Department();
		d1.setName("HR");
		d1.setLoc("Jspider, BTM");
		Employee e5 = new Employee();
		e5.setName("Chandru");
		e5.setSal(40000);
		e5.setDegn("HR");
		Employee e6 = new Employee();
		e6.setName("Kavya");
		e6.setSal(40000);
		e6.setDegn("HR");
		Employee e7 = new Employee();
		e7.setName("Vidyashree");
		e7.setSal(40000);
		e7.setDegn("HR");
		List<Employee> li1 = Arrays.asList(e5, e6, e7);
		d1.setEmp(li1);
		em.persist(d1);
		tran.commit();
	}
}
