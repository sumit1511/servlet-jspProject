package com.java.controller;

import com.java.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class StudentSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentRollNumber = req.getParameter("studentSearchRollNumber");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        int flag=0;
        for(Map.Entry entry: StudentRegistrationFormServlet.studentDetailList.entrySet()) {

            if (((Student)entry.getValue()).getStudentRollNumber().equals(studentRollNumber)) {
                req.setAttribute("student",entry.getValue());
               // printWriter.println(entry.getValue());
               flag=1;
                break;
            }
        }
        if(flag==0)
        {
           printWriter.println("this roll number not found in database");
        }

    }
}
