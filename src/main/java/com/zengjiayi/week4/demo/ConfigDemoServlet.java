package com.zengjiayi.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//use @WebServlet - no web.xml code
@WebServlet(
        urlPatterns = {"/config"},
        initParams ={
                @WebInitParam(name = "name", value = "Zeng Jiayi"),
                @WebInitParam(name = "studentId", value = "2019211001001202")
        }
)
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");
        PrintWriter writer = response.getWriter();
        writer.println("Name:" + name);
        writer.println("<StudentID:" + studentId);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
