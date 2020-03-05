package com.java.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentNameValidationFilter implements Filter
{

    FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
          this.filterConfig=filterConfig;
            filterConfig.getServletContext().log(this.getClass()+" Filter init method");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterConfig.getServletContext().log(this.getClass()+" Filter doFilter method");
            servletResponse.setContentType("text/html");
            PrintWriter printWriter = servletResponse.getWriter();
            String studentName = servletRequest.getParameter("studentName");
            Pattern pattern = Pattern.compile("[a-zA-Z]*");
            Matcher matcher = pattern.matcher(studentName);
            if (matcher.matches())
            {
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                printWriter.println("Student Name '"+ studentName + "' contains special character");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log(this.getClass()+" Filter destroy method");
    }
}
