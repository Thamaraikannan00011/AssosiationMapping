package jpa.association.manytomany;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AssignmentUni {
	
	public static void findBatchById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		BatchUni b = em.find(BatchUni.class, id);
		if(b != null) {
			System.out.println("=================== find batch by id ======================");
			System.out.println(b);
		}else {
			System.err.println("No batch info found since id is invalid");
		}
		System.out.println("===========================================================");
	}
	
	public static void findBatchBySubject(String batchCode) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT b FROM BatchUni b WHERE b.batchCode = ?1");
		q.setParameter(1, batchCode);
		List<BatchUni> li = q.getResultList();
		if(!li.isEmpty()) {
			System.out.println("=================== find batch by id ======================");
			for(BatchUni b : li) {
				System.out.println(b);
			}
		}
		else {
			System.err.println("No batch info found since id is invalid");
		}
		System.out.println("===========================================================");
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the batch id to find : ");
		int id = sc.nextInt();
		findBatchById(id);
		
		System.out.println("Enter the batch code to find : ");
		String batchCode = sc.next();
		findBatchBySubject(batchCode);
		
		sc.close();
	}
}
