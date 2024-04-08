package com.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.entity.Student;
import com.mvc.repository.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(Student s) {
		studentRepository.addStudent(s);
	}

	public List<Student> displayAllStudent() {
		List<Student> list = studentRepository.displayAllStudent();
		return list;
	}
	public Student getStudentData(int studentId) {
		Student s = studentRepository.getStudentData(studentId);
		return s;
	}

	public void updateStudent(int studentId, String studentName, String studentEmail, String studentPassword) {
		studentRepository.updateStudent(studentId, studentName, studentEmail, studentPassword);
	}
	
	public void deleteStudent(int studentId) {
		studentRepository.deleteStudent(studentId);
	}
}
