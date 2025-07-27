package jpa.association.onetoone;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/*
 * 1. find Person by id
 * 2. find Person by name
 * 3. find PanCrad by person id
 * */

public class AssignmentUni {
	
	public static void findPersonById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
		EntityManager em = emf.createEntityManager();
		PersonUni p =  em.find(PersonUni.class, id);
		System.out.println("=================== find person by Id =======================");
		if(p != null) {
			System.out.println(p);
		}else {
			System.err.println("No person data found by given id");
		}
		System.out.println("======================================================");
	}
	
	public static void findPersonByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p FROM PersonUni p WHERE p.name = ?1");
		q.setParameter(1, name);
		List<PersonUni> li = q.getResultList();
		System.out.println("=================== find person by name =======================");
		if(!li.isEmpty()) {
			for(PersonUni p : li) {
				System.out.println(p);
			}
		}else {
			System.err.println("No person data found by given id");
		}
		System.out.println("======================================================");
	}
	
	public static void findPancardByPersonid(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p.card FROM PersonUni p WHERE p.id = ?1");
		q.setParameter(1, id);
		try{
			PancardUni p = (PancardUni)q.getSingleResult();
			System.out.println("=================== find pancard by person id =======================");
			System.out.println(p);
		}catch(NoResultException e) {
			System.err.println("No person data found by given id");
		}
		System.out.println("======================================================");

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the person id to find : ");
		int id = sc.nextInt();
		findPersonById(id);
		
		System.out.println("Enter the person name to find : ");
		String name = sc.next();
		findPersonByName(name);
		
		System.out.println("Enter the person id to find pancard : ");
		int id1 = sc.nextInt();
		findPancardByPersonid(id1);
		sc.close();
	}

}
