package com.novatech.taskmanager.controller;

import com.novatech.taskmanager.dao.UserDAO;
import com.novatech.taskmanager.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Input validation
        if (username == null || username.trim().isEmpty() || username.length() < 3) {
            request.setAttribute("error", "Username must be at least 3 characters.");
            request.getRequestDispatcher("views/signup.jsp").forward(request, response);
            return;
        }

        if (password == null || password.trim().isEmpty() || password.length() < 6) {
            request.setAttribute("error", "Password must be at least 6 characters.");
            request.getRequestDispatcher("views/signup.jsp").forward(request, response);
            return;
        }

        // Check if user exists
        if (userDAO.getUserByUsername(username) != null) {
            request.setAttribute("error", "Username already exists.");
            request.getRequestDispatcher("views/signup.jsp").forward(request, response);
            return;
        }

        // All good — create new user
        userDAO.addUser(new User(username, password));
        response.sendRedirect("views/login.jsp");
    }
}
