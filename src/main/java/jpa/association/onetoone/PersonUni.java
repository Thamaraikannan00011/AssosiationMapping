package jpa.association.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person_Uni")
public class PersonUni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private PancardUni card;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PancardUni getCard() {
		return card;
	}
	public void setCard(PancardUni card) {
		this.card = card;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "PersonUni [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
}
