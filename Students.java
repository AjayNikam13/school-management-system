package SchoolManagement.dto;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Students 
{
	@Id
	private int sId;
	private String sName;
	private String sDob;
	private String sEmail;
	private String sPass;
	
	
//	@OneToMany
//	private List<Assignment> assignment;
		
	
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsDob() {
		return sDob;
	}
	public void setsDob(String sDob) {
		this.sDob = sDob;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPass() {
		return sPass;
	}
	public void setsPass(String sPass) {
		this.sPass = sPass;
	}
//	public List<Assignment> getAssignment() {
//		return assignment;
//	}
//	public void setAssignment(List<Assignment> assignment) {
//		this.assignment = assignment;
//	}
	
	
	

}
