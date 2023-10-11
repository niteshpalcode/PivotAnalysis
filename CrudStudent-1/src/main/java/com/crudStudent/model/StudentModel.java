package com.crudStudent.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity

public class StudentModel {
//	@Id
	private Integer studentId;
	private String firstName;
	private String lastName;
	private String email;
	private Date date;
	private String standard;
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentModel(Integer studentId, String firstName, String lastName, String email, Date date,
			String standard) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.standard = standard;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", date=" + date + ", standard=" + standard + "]";
	}
	
}
