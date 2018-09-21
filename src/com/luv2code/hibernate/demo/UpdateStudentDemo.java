package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

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
			System.out.println("Updating Student");
			student.setFirstName("Scooby");
			
			//get transaction and commit
			session.getTransaction().commit();
			System.out.println("COMPLETE");
			
			//NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//get and commit transactions
			session.getTransaction().commit();
			
			System.out.println("COMPLETE!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
