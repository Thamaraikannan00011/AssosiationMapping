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

public class AssignmentBi {
	
	public static void findUserById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
		EntityManager em = emf.createEntityManager();
		UserBi p =  em.find(UserBi.class, id);
		System.out.println("=================== find User by Id =======================");
		if(p != null) {
			System.out.println(p);
		}else {
			System.err.println("No User data found by given id");
		}
		System.out.println("======================================================");
	}
	
	public static void findUserByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM UserBi u WHERE u.name = ?1");
		q.setParameter(1, name);
		List<UserBi> li = q.getResultList();
		System.out.println("=================== find User by name =======================");
		if(!li.isEmpty()) {
			for(UserBi u : li) {
				System.out.println(u);
			}
		}else {
			System.err.println("No person data found by given id");
		}
		System.out.println("======================================================");
	}
	
	public static void findAadharcardByUserid(int id) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
	    EntityManager em = emf.createEntityManager();
	    try {
	        Query q = em.createQuery("SELECT u.card FROM UserBi u WHERE u.id = ?1");
	        q.setParameter(1, id);
	        AadharBi a = (AadharBi)q.getSingleResult();
	        System.out.println("=================== find aadhar by user id =======================");
	        System.out.println(a);
	    } catch(NoResultException e) {
	        System.err.println("No Aadhar card found for user id: " + id);
	    }
	    System.out.println("======================================================");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the person id to find : ");
		int id = sc.nextInt();
		findUserById(id);
		
		System.out.println("Enter the person name to find : ");
		String name = sc.next();
		findUserByName(name);
		
		System.out.println("Enter the User id to find Aadharcard : ");
		int id1 = sc.nextInt();
		findAadharcardByUserid(id1);
		sc.close();
	}

}
