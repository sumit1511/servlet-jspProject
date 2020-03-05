package com.java.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log(this.getClass()+" listener initialization method");
        Properties prop = null;
        ServletContext context=servletContextEvent.getServletContext();

        String propertyFilePath=context.getInitParameter("propertiesFile");  ;
        try {
            prop = readPropertiesFile(propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        context.setAttribute("props", prop);
        context.setAttribute("studentRollNumber",prop.getProperty("studentRollNumber"));
        context.setAttribute("studentName",prop.getProperty("studentName"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log(this.getClass()+" listener initialization method");
    }
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
