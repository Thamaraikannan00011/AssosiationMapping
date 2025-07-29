package jpa.association.onetomanyuni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double sal;
	private String degn;
	
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getDegn() {
		return degn;
	}
	public void setDegn(String degn) {
		this.degn = degn;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", degn=" + degn + "]";
	}
	
}
