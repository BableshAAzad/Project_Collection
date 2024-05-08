package com.stu;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.stu.entity.Course;
import com.stu.entity.Student;

public class App {
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("AutowireDefault.xml"));
		Student student1 = (Student) beanFactory.getBean("student1");
		Student student2 = (Student) beanFactory.getBean("student2");
		Student student3 = (Student) beanFactory.getBean("student3");
		Student student4 = (Student) beanFactory.getBean("student4");
		
		Course course1 = (Course) beanFactory.getBean("course1");
		Course course2 = (Course) beanFactory.getBean("course2");
		Course course3 = (Course) beanFactory.getBean("course3");
		Course course4 = (Course) beanFactory.getBean("course4");
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
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
