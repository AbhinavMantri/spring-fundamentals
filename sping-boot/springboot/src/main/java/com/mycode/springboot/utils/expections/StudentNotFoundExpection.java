package com.mycode.springboot.utils.expections;

public class StudentNotFoundExpection extends RuntimeException {
    public StudentNotFoundExpection(String message) {
        super(message);
    }
}
