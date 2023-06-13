package com.jsp.springbootexcelfileintodatabaseproject.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {

	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private long studentPhone;
	private int studentMarks;
	
	public Student(int studentId, String studentName, String studentEmail, long studentPhone, int studentMarks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentMarks = studentMarks;
	}
	
	public Student() {
		
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}
	
	
	
	
	
	
}
