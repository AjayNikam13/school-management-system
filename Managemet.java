package SchoolManagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Managemet 
{
	@Id
	private int mId;
	private String mEmail;
	private String mPass;
	
	
	
	
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPass() {
		return mPass;
	}
	public void setmPass(String mPass) {
		this.mPass = mPass;
	}
	
	
	
	
}
