package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Instructor;
import com.code.jdbc.entity.InstructorDetails;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetails.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Jack", "Martin", "jakemartin@gmail.com");

            InstructorDetails instructorDetails = new InstructorDetails("funmozo", "doing some fun");

            instructor.setInstructorDetails(instructorDetails);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
