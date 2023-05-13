package SchoolManagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Assignment 
{
	@Id
	private int sId;
	private int aId;
	private int aMarks;
	private String aName;
	
//	@ManyToOne
//	private Students students;
	
	
	public int getaId() {
		return aId;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getaMarks() {
		return aMarks;
	}
	public void setaMarks(int aMarks) {
		this.aMarks = aMarks;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
//	public Students getStudents() {
//		return students;
//	}
//	public void setStudents(Students students) {
//		this.students = students;
//	}
	
	
	
	
	
}
