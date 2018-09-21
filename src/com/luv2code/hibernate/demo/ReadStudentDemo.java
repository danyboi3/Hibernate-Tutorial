package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create student object
			System.out.println("Creating Student object");
			Student student = new Student("Mohammad", "Danyal", "MohammadDanyal96@hotmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving Student");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("DB entry COMPLETE");
			
			//find student id
			System.out.println("ID saved: " + student.getId());
			
			//get new session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id
			System.out.println("\nGetting student id: " + student.getId());
			Student retrievedStudent = session.get(Student.class, student.getId());
			System.out.println("Get complete " + retrievedStudent);
			
			//get transaction and commit
			session.getTransaction().commit();
			System.out.println("COMPLETE");
			
		}
		finally {
			factory.close();
		}
		
	}

}
