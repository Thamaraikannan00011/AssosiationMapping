package jpa.association.onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveUniAssociation {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne	");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		
		PersonUni p = new PersonUni();
		p.setName("Kavi");
		p.setAge(21);
		p.setEmail("kavi@gmail.com");
		PancardUni card = new PancardUni();
		card.setAddress("KRP");
		card.setPhone(9900998877l);
		card.setPincode(636709);
		p.setCard(card);
		em.persist(p);
		
		PersonUni p1 = new PersonUni();
		p1.setName("Sri");
		p1.setAge(20);
		p1.setEmail("sri@gmail.com");
		PancardUni card1 = new PancardUni();
		card1.setAddress("DPI");
		card1.setPhone(9234567887l);
		card1.setPincode(636708);
		p1.setCard(card1);
		em.persist(p1);
		
		tran.commit();
		
	}

}
