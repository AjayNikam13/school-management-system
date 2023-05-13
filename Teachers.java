package SchoolManagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teachers 
{
	@Id
	private int tId;
	private String tName;
	private String tSub;
	private int tAge;
	private String tEmail;
	private String tPass;
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettSub() {
		return tSub;
	}
	public void settSub(String tSub) {
		this.tSub = tSub;
	}
	public int gettAge() {
		return tAge;
	}
	public void settAge(int tAge) {
		this.tAge = tAge;
	}
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	public String gettPass() {
		return tPass;
	}
	public void settPass(String tPass) {
		this.tPass = tPass;
	}
	
	
	
}	
