package com.java.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentRollNumberValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                 try {
                     servletResponse.setContentType("text/html");
                     PrintWriter printWriter = servletResponse.getWriter();
                     String studentRollNumber = servletRequest.getParameter("studentRollNumber");
                     Pattern pattern = Pattern.compile("RN[0-9]+");
                     Matcher matcher = pattern.matcher(studentRollNumber);
                     if (matcher.matches())
                     {
                         filterChain.doFilter(servletRequest,servletResponse);
                     }
                     else
                         printWriter.println("Roll Number Formate is not match");
                 }
                 catch (Exception e)
                 {
                     e.printStackTrace();
                 }
    }

    @Override
    public void destroy() {

    }
}
