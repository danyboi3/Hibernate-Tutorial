package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//query students
			List<Student> students = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(students);
			
			//query students with last name Danyal
			students = session.createQuery("from Student s where s.lastName='Danyal' ").getResultList();
			
			//print students with last name Danyal
			System.out.println("\n\n\n");
			displayStudents(students);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("DB commit Done");
			
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student stud : students) {
			System.out.println(stud);
		}
	}

}
