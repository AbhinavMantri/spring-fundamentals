package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Student;

public class PrimaryDemo {
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
            Student student1 = new Student("Mike", "Travis", "mike.travis@gmail.com");
            Student student2 = new Student("Edward", "Nikas", "edward.nikas@gmail.com");
            Student student3 = new Student("Kamal", "Khanha", "kamal.khanha@gmail.com");
            // start transaction
            session.beginTransaction();

            // save the student object
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            factory.close();
        }
    }
}
