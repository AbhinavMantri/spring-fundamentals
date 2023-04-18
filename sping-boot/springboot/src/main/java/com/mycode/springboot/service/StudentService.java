package com.mycode.springboot.service;

import java.util.List;

import com.mycode.springboot.entity.Student;

public interface StudentService {
    public Student getStudent(int studentId);

    public List<Student> getStudents();

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudent(int studentId);
}
