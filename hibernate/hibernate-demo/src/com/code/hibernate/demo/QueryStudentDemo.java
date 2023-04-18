package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Student;

public class QueryStudentDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // session factory
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

        // crate session                
        Session session = factory.getCurrentSession();

        try {
            // start transaction
            session.beginTransaction();

            // query for the students
            List<Student> students = session.createQuery("from Student").list();

            // display the students
            displayStudents(students);

            // query with filter
            students = session.createQuery("from Student s where s.lastName = 'Nikas'").list();

            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName IN ('Travis', 'Sanker')")
                    .list();

            // display the filtered students
            displayStudents(students);

            students = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();

            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        // display the students
        for( Student s: students) {
            System.out.println(s.toString());
        }
    }
}
