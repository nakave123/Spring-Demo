/**
 * 
 */
package edu.neu.spring.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author pratiknakave
 *
 */
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long Id;
	@Column(name = "FIRST_NAME")
	private String fName;
	@Column(name = "LAST_NAME")
	private String lName;
	@Column(name = "EMP_EMAIL")
	private String email;
	@Lob
	@Column(name="CATEGORY_PHOTO")
	private byte[] categoryPhoto;

	public Employee() {
		
	}
	
	/**
	 * @param Id
	 * @param fName
	 * @param lName
	 * @param email
	 */
	public Employee(long Id, String fName, String lName, String email, byte[] categoryPhoto) {
		super();
		this.Id = Id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.categoryPhoto = categoryPhoto;
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
	public byte[] getCategoryPhoto() {
		return categoryPhoto;
	}
	public void setCategoryPhoto(byte[] categoryPhoto) {
		categoryPhoto = categoryPhoto;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}
	
	
}
