package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Expectations;

import com.code.jdbc.entity.Course;
import com.code.jdbc.entity.Instructor;
import com.code.jdbc.entity.InstructorDetails;
import com.code.jdbc.entity.Review;

public class OneToManyUniDemo {
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

            Course course = session.get(Course.class, 3);

            Review review = new Review("Love it");
            Review review2 = new Review("too informative course");
            Review review3 = new Review("too bad");

            course.addReview(review);
            course.addReview(review2);
            course.addReview(review3);

            session.save(course);

            session.getTransaction().commit();

            System.out.println(course);

            System.out.println(course.getReviews());

        } catch(Exception err) {
            err.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }   
    }    
}
