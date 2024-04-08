package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.entity.Student;
import com.mvc.services.StudentServices;

@Controller
public class StudentController {
	@Autowired
	private StudentServices studentServices;

	@RequestMapping(value = "/studentAdd", method = RequestMethod.POST)
	public String addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		String studentName = req.getParameter("studentName");
		String studentEmail = req.getParameter("studentEmail");
		String studentPassword = req.getParameter("studentPassword");

		Student s = new Student();
		s.setStudentId(studentId);
		s.setStudentName(studentName);
		s.setStudentEmail(studentEmail);
		s.setStudentPassword(studentPassword);
		studentServices.addStudent(s);

//		req.setAttribute("studentName", studentName); // What
//		RequestDispatcher rd = req.getRequestDispatcher("addedStudendt.jsp"); // Where
//		rd.forward(req, resp);
		return "index.jsp";
	}

	@RequestMapping(value = "/displayAllStudent", method = RequestMethod.GET)
	public void displayAllStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Student> list = studentServices.displayAllStudent();

		req.setAttribute("list", list); // What
		RequestDispatcher rd = req.getRequestDispatcher("displayAllStudent.jsp"); // Where
		rd.forward(req, resp);
	}
	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public void getStudentData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		Student s = studentServices.getStudentData(studentId);
		req.setAttribute("student", s); // What
		RequestDispatcher rd = req.getRequestDispatcher("updateStudent.jsp"); // Where
		rd.forward(req, resp);
	}
	
	@RequestMapping(value = "/updateStu", method = RequestMethod.POST)
	public String updateStudent(HttpServletRequest req, HttpServletResponse resp) {
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		String studentName = req.getParameter("studentName");
		String studentEmail = req.getParameter("studentEmail");
		String studentPassword  = req.getParameter("studentPassword");
		studentServices.updateStudent(studentId, studentName, studentEmail, studentPassword);
		return "index.jsp";
	}
	
	@RequestMapping(value ="/deleteStudent", method = RequestMethod.GET)
	public String deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		System.out.println(studentId);
		studentServices.deleteStudent(studentId);
		return "index.jsp";
	}
	
}
