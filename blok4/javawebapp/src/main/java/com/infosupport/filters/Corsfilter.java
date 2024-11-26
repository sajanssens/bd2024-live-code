package com.infosupport.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/contacts")
public class Corsfilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // doe iets met het request voordat je doorgaat

        // ga door
        filterChain.doFilter(servletRequest, servletResponse);

        // doe iets met het response voordat je teruggaat
        ((HttpServletResponse) servletResponse).setHeader("Access-control-allow-headers", "*"); // to support OPTIONS
        ((HttpServletResponse) servletResponse).setHeader("Access-control-allow-origin", "http://localhost:4200");
    }
}
