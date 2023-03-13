package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Student.class)
                            .buildSessionFactory();

        // create session
        Session session  = factory.getCurrentSession();

        try {

            // create a student object
            Student newStudent = new Student("Paul", "Walker", "paul.walker@gmail.com");
            // start transaction
            session.beginTransaction();

            // save the student object
            session.save(newStudent);

            // commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            factory.close();
        }
    }
}
