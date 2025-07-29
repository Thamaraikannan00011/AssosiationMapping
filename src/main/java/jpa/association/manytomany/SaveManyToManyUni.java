package jpa.association.manytomany;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveManyToManyUni {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		
		StudentUni s1 = new StudentUni();
		s1.setName("Dharani");
		s1.setPhone(7010981262l);
		s1.setPercentage(80.0);
		
		StudentUni s2 = new StudentUni();
		s2.setName("Arani");
		s2.setPhone(7010081262l);
		s2.setPercentage(85.6);
		
		StudentUni s3 = new StudentUni();
		s3.setName("Navin");
		s3.setPhone(9999981262l);
		s3.setPercentage(79.6);
		
		BatchUni b1 = new BatchUni();
		b1.setBatchCode("Java-B1");
		b1.setBatchName("Core Java");
		b1.setTrainer("Abhishek");
		b1.setStudent(Arrays.asList(s1, s2, s3));

		BatchUni b2 = new BatchUni();
		b2.setBatchCode("SQL-B2");
		b2.setBatchName("sql");
		b2.setTrainer("Krishna");
		b2.setStudent(Arrays.asList(s1, s2));
		
		em.persist(b1);
		em.persist(b2);
		tran.commit();
	}
}
