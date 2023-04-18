package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Student.class)
                            .buildSessionFactory();

        // create session
        Session session  = factory.getCurrentSession();

        try {

            int studentId = 1;

            // start transaction
            session.beginTransaction();

            // retrieve the student

            // save the student object
            Student student = session.get(Student.class, studentId);

            student.setEmail("paul.walker009@gmail.com");

            //query with update
            // session
            //     .createQuery("update Student set email='mike_travis@gmail.com' where id = 1")
            //     .executeUpdate();

            // commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            factory.close();
        }
    }
}
