package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.jdbc.entity.Course;
import com.code.jdbc.entity.Instructor;
import com.code.jdbc.entity.InstructorDetails;
import com.code.jdbc.entity.Review;

public class OneToManyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetails.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Review.class)
                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 6);

            System.out.println(instructor.getCourses());

            Course course1 = new Course("Wall paint");
            Course course2 = new Course("Crystal art");

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.update(instructor);

            // Instructor instructor = new Instructor("Hemlata", "mandvi", "hemalata@gmail.com");

            // InstructorDetails instructorDetails = new InstructorDetails("Hemlata arts", "Arts");

            // instructor.setInstructorDetails(instructorDetails);

            // Course course1 = new Course("Sketeching");
            // Course course2 = new Course("Arts");

            // instructor.addCourse(course1);
            // instructor.addCourse(course2);

            // session.save(course1);
            // session.save(course2);
            // session.save(instructor);

            System.out.println(instructor.toString());

            System.out.println(instructor.getInstructorDetails().toString());
            List<Course> courses = instructor.getCourses();
            for(Course course : courses) {
                System.out.println(course.toString());
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
