package jpa.association.onetomanyuni;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String loc;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> emp;
	
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", loc=" + loc + "]";
	}
}
