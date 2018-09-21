package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create a student objects
			System.out.println("createing student objects");
			Student student1 = new Student("John", "Doe", "JohnDoe@gmail.com");
			Student student2 = new Student("Paul", "Walker", "PaulWalker@gmail.com");
			Student student3 = new Student("Mary", "Public", "MaryPublic@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save transaction
			System.out.println("Saving");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//get transaction commit
			session.getTransaction().commit();
			System.out.println("COMPLETE");
		}
		finally {
			factory.close();
		}
		
	}

}
