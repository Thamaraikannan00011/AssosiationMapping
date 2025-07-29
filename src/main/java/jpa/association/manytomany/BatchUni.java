package jpa.association.manytomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class BatchUni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String batchCode;
	private String batchName;
	private String trainer;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<StudentUni> student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public List<StudentUni> getStudent() {
		return student;
	}
	public void setStudent(List<StudentUni> student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "BatchUni [id=" + id + ", batchCode=" + batchCode + ", batchName=" + batchName + ", trainer=" + trainer
				+ "]";
	} 
}
