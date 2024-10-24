package org.rbnk.someapi.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
    private static final String UTF8 = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("<encoding filter init>");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html; charset=UTF-8");
        servletResponse.setCharacterEncoding(UTF8);
        servletRequest.setCharacterEncoding(UTF8);

        PrintWriter out = servletResponse.getWriter();
        out.write(UTF8);
        out.write("<br/>");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("<encoding filter destroy>");
    }
}

