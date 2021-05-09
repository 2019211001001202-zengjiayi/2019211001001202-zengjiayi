package com.zengjiayi.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter",urlPatterns = "/hello")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoggerFilter-->doFilter() before servlet-(request come here)");
        chain.doFilter(request, response);
        System.out.println("i am in LoggerFilter-->doFilter() after servlet-(request come here)");
    }
}
