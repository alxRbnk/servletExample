package org.rbnk.someapi.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;


@WebFilter(urlPatterns = {"/*"})
public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("<language filter init>");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String langParam = httpRequest.getParameter("lang");
        Locale locale;
        if (langParam != null && !langParam.isEmpty()) {
            locale = new Locale(langParam);
        } else {
            locale = httpRequest.getLocale();
        }
        servletRequest.setAttribute("language", locale.getLanguage());
        PrintWriter out = servletResponse.getWriter();
        out.write(locale.getLanguage());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("<language filter destroy>");
    }
}

