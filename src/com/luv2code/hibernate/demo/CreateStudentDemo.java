package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentDemo {

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
			System.out.println("COMPLETE");
		}
		finally {
			factory.close();
		}
		
	}

}
