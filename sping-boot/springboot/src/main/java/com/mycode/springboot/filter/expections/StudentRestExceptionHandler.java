package com.mycode.springboot.filter.expections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycode.springboot.model.StudentErrorResponse;
import com.mycode.springboot.utils.expections.StudentNotFoundExpection;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExpection(StudentNotFoundExpection exec) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setMessage(exec.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
