package org.rbnk.someapi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "firstServlet", value = "/first/*")
public class FirstController extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = (String) request.getAttribute("language");
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale(language));
        response.getWriter().println("<h1>" + messages.getString("greeting") + "</h1>");
    }

    @Override
    public void destroy() {
    }
}


