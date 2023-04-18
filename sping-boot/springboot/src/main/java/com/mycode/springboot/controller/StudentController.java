package com.mycode.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.springboot.entity.Student;
import com.mycode.springboot.service.StudentService;
import com.mycode.springboot.utils.expections.StudentNotFoundExpection;

// @RestController
// @RequestMapping("/student")
public class StudentController {

    // private StudentService service;

    // public StudentController(@Autowired StudentService service) {
    //     this.service = service;
    // }

    // @GetMapping("/")
    // public List<Student> getStudents() {
    //     return service.getStudents();
    // }
   
    // @GetMapping("/{studentId}") 
    // public Student getStudent(@PathVariable int studentId) {
    //     Student student = service.getStudent(studentId);

    //     if(student == null) {
    //         throw new StudentNotFoundExpection("Student is not found");
    //     }

    //     return student;
    // }

    // @PostMapping("/")
    // public Student addStudent(@RequestBody Student student) {
    //     Student theStudent = service.addStudent(student);

    //     return theStudent;
    // }

    // @PutMapping("/{studentId}")
    // public Student updateStudent(@RequestBody Student student, @PathVariable int studentId) {
    //     student.setId(studentId);
    //     Student theStudent = service.updateStudent(student);

    //     return theStudent;
    // }

    // @DeleteMapping("/{studentId}")
    // public void deleteStudent(@PathVariable int studentId) {
    //     service.deleteStudent(studentId);
    // }
}
