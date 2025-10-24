package com.example.laboratorsp.laborator4.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("[LOG BEFORE] " + req.getMethod() + " " + req.getRequestURI() + " at " + LocalDateTime.now());

        chain.doFilter(request, response);

        System.out.println("[LOG AFTER] " + req.getMethod() + " " + req.getRequestURI() + " at " + LocalDateTime.now());
    }
}