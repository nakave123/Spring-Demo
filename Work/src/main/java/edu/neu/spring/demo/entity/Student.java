/**
 * 
 */
package edu.neu.spring.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pratiknakave
 *
 */
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@Column(name = "fName")
	private String fName;
	@Column(name = "lName")
	private String lName;
	@Column(name = "email")
	private String email;
	
	public Student() {
		
	}
	
	/**
	 * @param Id
	 * @param fName
	 * @param lName
	 * @param email
	 */
	public Student(long Id, String fName, String lName, String email) {
		super();
		this.Id = Id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
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
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}

}
