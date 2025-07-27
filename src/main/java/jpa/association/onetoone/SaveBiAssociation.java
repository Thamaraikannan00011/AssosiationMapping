package jpa.association.onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveBiAssociation {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOne");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		UserBi u = new UserBi();
		u.setName("Dharani");
		u.setPhone(7010986226l);
		u.setAddress("Musuri");
		AadharBi c1 = new AadharBi();
		c1.setAadharNumber(654312340987l);
		c1.setUser(u);
		u.setCard(c1);
		em.persist(u);
		
		UserBi u1 = new UserBi();
		u1.setName("Dhachina");
		u1.setPhone(7010900026l);
		u1.setAddress("Dpi");
		AadharBi c2 = new AadharBi();
		c2.setAadharNumber(666612340987l);
		c2.setUser(u1);
		u.setCard(c2);
		em.persist(c2);
		tran.commit();
	}
}
