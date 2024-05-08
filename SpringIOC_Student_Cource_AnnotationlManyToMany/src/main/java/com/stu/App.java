package com.stu;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stu.entity.Course;
import com.stu.entity.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student1 = ac.getBean(Student.class);
		student1.setStudentId(101);
		student1.setStudentName("Bablesh");
		student1.setStudentEmail("bablesh@gmail.com");
		student1.setStudentAge(21);

		Student student2 = ac.getBean(Student.class);
		student2.setStudentId(102);
		student2.setStudentName("Kumar");
		student2.setStudentEmail("ku@gmail.com");
		student2.setStudentAge(19);

		Student student3 = ac.getBean(Student.class);
		student3.setStudentId(103);
		student3.setStudentName("AAzad");
		student3.setStudentEmail("az@gmail.com");
		student3.setStudentAge(20);

		Student student4 = ac.getBean(Student.class);
		student4.setStudentId(104);
		student4.setStudentName("Durgesh");
		student4.setStudentEmail("dk@gmail.com");
		student4.setStudentAge(24);

// ------------------------------------------------------

		Course course1 = ac.getBean(Course.class);
		course1.setCourseId(1);
		course1.setCourseName("java");
		course1.setCoursePrice(24000);
		course1.setCourseDuration("7 months");

		Course course2 = ac.getBean(Course.class);
		course2.setCourseId(2);
		course2.setCourseName("Reactjs");
		course2.setCoursePrice(40000);
		course2.setCourseDuration("5 months");

		Course course3 = ac.getBean(Course.class);
		course3.setCourseId(3);
		course3.setCourseName("sql");
		course3.setCoursePrice(30000);
		course3.setCourseDuration("6 months");

		Course course4 = ac.getBean(Course.class);
		course4.setCourseId(4);
		course4.setCourseName("python");
		course4.setCoursePrice(55000);
		course4.setCourseDuration("11 months");

//------------------------------------------------------

		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);

		course1.setStudents(students);
		course2.setStudents(students);
		course3.setStudents(students);
		course4.setStudents(students);
//		----- ------ ------ ------ -------
		List<Course> course = new ArrayList<>();
		course.add(course1);
		course.add(course2);
		course.add(course3);
		course.add(course4);

		student1.setCourses(course);
		student2.setCourses(course);
		student3.setCourses(course);
		student4.setCourses(course);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);

		session.save(course1);
		session.save(course2);
		session.save(course3);
		session.save(course4);

		tx.commit();
		session.close();

	}
}
