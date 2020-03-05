package com.java.controller;

import com.java.model.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class StudentRegistrationFormServlet extends HttpServlet
{


    public static Map<String, Student> studentDetailList= new HashMap<>();

    @Override
    public void init() throws ServletException {
        getServletContext().log(this.getClass() + "servlet init method");
        super.init();
    }

    @Override
     public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().log(this.getClass() + "servlet dopost method");
        String studentRollNumber = req.getParameter("studentRollNumber");
        String studentName = req.getParameter("studentName");
        String studentUniversity = req.getParameter("studentUniversity");
        Student student = new Student(studentName,studentRollNumber,studentUniversity);
        studentDetailList.put(studentRollNumber,student);
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(studentName+" "+studentRollNumber+" "+studentUniversity+"data successfully added into student list");
        printWriter.println(studentDetailList);
    }

    @Override
    public void destroy() {
        getServletContext().log(this.getClass() + "servlet destroy method");
        super.destroy();

    }
}
