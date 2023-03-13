package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Student.class)
                            .buildSessionFactory();

        // create session
        Session session  = factory.getCurrentSession();

        try {

            int studentId = 5;

            // start transaction
            session.beginTransaction();

            // save the student object
            Student student = session.get(Student.class, studentId);

            // delete the student object
            session.delete(student);

            // delete with query
            // session.createQuery("delete from Student where id = 5")
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
