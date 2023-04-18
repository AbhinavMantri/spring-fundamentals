package com.mycode.springboot.dao;

import java.rmi.StubNotFoundException;
import java.util.List;

import com.mycode.springboot.entity.Student;

public interface StudentDAO {
    public Student save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByName(String name);

    public Student update(Student student);

    public void delete(Integer id);
}
