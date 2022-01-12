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
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SID")
	private long sId;
	@Column(name = "FIRST_NAME")
	private String fName;
	@Column(name = "LAST_NAME")
	private String lName;
	@Column(name = "STUD_EMAIL")
	private String email;
	@Lob
	@Column(name="CATEGORY_PHOTO")
	private byte[] categoryPhoto;
	@Lob
	@Column(name="CATEGORY_CV")
	private byte[] categoryFile;
	
	public Student() {
		
	}
	
	/**
	 * @param Id
	 * @param fName
	 * @param lName
	 * @param email
	 */
	public Student(long Id, String fName, String lName, String email, byte[] categoryPhoto, byte[] categoryFile) {
		super();
		this.sId = Id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.categoryPhoto = categoryPhoto;
		this.categoryFile = categoryFile;
	}
	
	public long getsId() {
		return sId;
	}
	public void setsId(long Id) {
		this.sId = Id;
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
	public byte[] getCategoryFile() {
		return categoryFile;
	}
	public void setCategoryFile(byte[] categoryFile) {
		this.categoryFile = categoryFile;
	}

	@Override
	public String toString() {
		return "Student [Id=" + sId + ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}

}
