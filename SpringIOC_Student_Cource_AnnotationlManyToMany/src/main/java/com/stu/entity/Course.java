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
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private int coursePrice;
	private String courseDuration;
	@ManyToMany
	private List<Student> students;

	public Course(int courseId, String courseName, int coursePrice, String courseDuration, List<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDuration = courseDuration;
		this.students = students;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
