package com.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";

        String user = "hbstudent";
        
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to the database:" + url);

            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("Connection has been established");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}