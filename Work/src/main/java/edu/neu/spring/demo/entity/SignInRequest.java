/**
 * 
 */
package edu.neu.spring.demo.entity;

/**
 * @author pratiknakave
 *
 */
public class SignInRequest {

	private String fName;
	private String lName;
	private String email;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
