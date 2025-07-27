package jpa.association.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aadhar_Bi")
public class AadharBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long aadharNumber;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "card")
	private UserBi user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public UserBi getUser() {
		return user;
	}
	public void setUser(UserBi user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "AadharBi [id=" + id + ", aadharNumber=" + aadharNumber + "]";
	}
}
