package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Course;
import com.code.jdbc.entity.Instructor;
import com.code.jdbc.entity.InstructorDetails;

public class BiDirectionalDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetails.class)
                        .addAnnotatedClass(Course.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            InstructorDetails instructorDetails = new InstructorDetails("GuitarPlay", "Guitar");

            Instructor instructor = new Instructor("Gopal", "Kishan", "gopalkishan@gmail.com");

            instructorDetails.setInstructor(instructor);

            session.save(instructorDetails);

            session.getTransaction().commit();

            System.out.println(instructorDetails.toString());

            System.out.println(instructorDetails.getInstructor().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
