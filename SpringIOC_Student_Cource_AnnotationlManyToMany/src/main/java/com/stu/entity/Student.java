package com.stu.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private int studentAge;
	@ManyToMany
	private List<Course> courses;

	public Student(int studentId, String studentName, String studentEmail, int studentAge, List<Course> courses) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAge = studentAge;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
