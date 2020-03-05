package com.java.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PropertyFileServlet extends HttpServlet{

    String name,rollNumber;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // initFields();
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(name+"\n"+rollNumber);
    }

    private void initFields()
       {

           ServletConfig servletConfig = getServletConfig();
           ServletContext servletContext =servletConfig.getServletContext();
           rollNumber=servletContext.getAttribute("studentRollNumber").toString();
           name=servletContext.getAttribute("studentName").toString();
//           System.out.println();
//           System.out.println();
       }

    @Override
    public void init() throws ServletException {
        super.init();
        initFields();
    }
}
