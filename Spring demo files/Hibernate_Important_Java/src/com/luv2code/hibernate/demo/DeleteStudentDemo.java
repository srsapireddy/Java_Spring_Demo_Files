package com.luv2code.hibernate.demo;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

// 191 --> Retreving the object from the database
public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory --> Creates session object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session --> To save or retrieve objects to and from the database.
		
		// Object to get the current session
		Session session =factory.getCurrentSession();
		
		try {
			
			// use the session object to update the Java object 
			

			// 199
			int studentId = 1;
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// delete the student
			// System.out.println("Deleting stu dent: " + myStudent);
			// session.delete(myStudent);
			
			// delete student id=2 --> Alternate approach --> There is no need to retrieve the object but we can delete it on the fly
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

}
