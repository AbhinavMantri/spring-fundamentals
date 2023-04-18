package com.mycode.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycode.springboot.entity.Student;
import com.mycode.springboot.utils.expections.StudentNotFoundExpection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    public StudentDAOImpl(@Autowired EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student student) {
       entityManager.persist(student);
       return student;
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
       TypedQuery<Student> typedQuery = entityManager.createQuery("from Student", Student.class);
       return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("from Student where firstName=:first", Student.class);
        
        typedQuery.setParameter("first", name);

        return typedQuery.getResultList();
    }

    @Override
    public Student update(Student student) {
       Student theStudent = entityManager.merge(student);
       return theStudent;
    }

    @Override
    public void delete(Integer id) {
        Student student = findById(id);
        
        if (student == null) {
            throw new StudentNotFoundExpection("Student is not Found");
        }

        entityManager.remove(student);
    }
}
