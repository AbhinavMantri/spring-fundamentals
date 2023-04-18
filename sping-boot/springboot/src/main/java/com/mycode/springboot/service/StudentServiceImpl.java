package com.mycode.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.mycode.springboot.dao.StudentDAO;
import com.mycode.springboot.entity.Student;
import com.mycode.springboot.repository.StudentRepository;
import com.mycode.springboot.utils.expections.StudentNotFoundExpection;

import jakarta.transaction.Transactional;

// @Service
public class StudentServiceImpl {
// implements StudentService {
    // private StudentDAO studentDAO;

    // private StudentRepository repository;

    // public StudentServiceImpl(@Autowired StudentRepository repository) {
    //     this.repository = repository;
    // }

    // @Override
    // public Student getStudent(int studentId)  {
    //     Optional<Student> theStudent = repository.findById(studentId);

    //     if(!theStudent.isPresent()) {
    //         throw new StudentNotFoundExpection("Student is not found");
    //     }

    //     return theStudent.get();
    // }

    // @Override
    // public List<Student> getStudents() {
    //     return repository.findAll();
    // }

    // @Override
    // @Transactional
    // public Student addStudent(Student student) {
    //    return repository.save(student);
    // }

    // @Override
    // @Transactional
    // public Student updateStudent(Student student) {
    //    return repository.save(student);
    // }

    // @Override
    // @Transactional
    // public void deleteStudent(int studentId) {
    //     if(!repository.existsById(studentId)) {
    //         throw new StudentNotFoundExpection("Student is not found");
    //     }

    //     repository.deleteById(studentId);
    // }
    
}
