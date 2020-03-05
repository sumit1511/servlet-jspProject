package com.java.filter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            filterChain.doFilter(servletRequest,servletResponse);
            servletResponse.setContentType("text/html");
            PrintWriter printWriter = servletResponse.getWriter();
            String content= ((HttpServletRequest)servletRequest).getHeader("Accept");
          //  printWriter.println(content +" context type request got");
            Object student = servletRequest.getAttribute("student");
           // printWriter.println(student);
            if(content!= null && content.equals("application/json")) {
                String json = new ObjectMapper().writeValueAsString(student);
                servletResponse.setContentType("application/json");
                printWriter.println(json);
            }
            else
            {
                XmlMapper xmlMapper = new XmlMapper();
                String xml = xmlMapper.writeValueAsString(student);
                servletResponse.setContentType("application/xml");
                printWriter.println(xml);
            }
    }
    @Override
    public void destroy() {

    }
}
