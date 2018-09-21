package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			//get new session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id
			System.out.println("\nGetting student id: " + studentId);
			
			Student student = session.get(Student.class, studentId);
			
			//delete student
			System.out.println("Deleting student: " + student);
			session.delete(student);
			
			//get transaction and commit
			session.getTransaction().commit();
			System.out.println("COMPLETE");
			
		}
		finally {
			factory.close();
		}
		
	}

}
