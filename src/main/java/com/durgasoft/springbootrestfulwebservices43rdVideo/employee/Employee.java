package com.durgasoft.springbootrestfulwebservices43rdVideo.employee;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Employee {
	
	private Integer id;
	@Size(min = 4,max = 100,message = "Name size should be between 4 and 100")
	private String name;
	private String email;
	private String contactNo;
	@Past(message = "Date Of Birth Should be Past Date")
	private java.util.Date dateOfBirth;
	
	public Employee() {
		
	}

    public Employee(Integer id, String name, String email, String contactNo, java.util.Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

    


	
}
