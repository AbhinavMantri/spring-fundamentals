package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Course;
import com.code.jdbc.entity.Instructor;
import com.code.jdbc.entity.InstructorDetails;
import com.code.jdbc.entity.Review;
import com.code.jdbc.entity.Student;

public class ManyToManyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetails.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Review.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = session.get(Course.class, 4);

            Student student = session.get(Student.class, 2);

            Student student2 = session.get(Student.class, 4);

            course.addStudent(student);
            course.addStudent(student2);

            session.update(course);

            session.getTransaction().commit();

            System.out.println(course);
            
            for(Student s : course.getStudents()) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }    
}
