package com.novatech.taskmanager.controller;

import com.novatech.taskmanager.dao.UserDAO;
import com.novatech.taskmanager.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/signup"})
public class AuthController extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String action = req.getServletPath();



        if (action.equals("/signup")) {
            System.out.println("signup auth");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User(username, password);
            boolean registered = userDAO.register(user);

            if (registered) {
                res.sendRedirect("index.jsp");
            } else {
                System.out.println("error with sign up");
                req.setAttribute("error", "Signup failed. Username already exist.");
                req.getRequestDispatcher("signup.jsp").forward(req, res);
            }
        } else if (action.equals("/login")) {
            System.out.println("login auth");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = userDAO.login(username, password);

            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                res.sendRedirect("index.jsp");
            } else {
                req.setAttribute("error", "Invalid username or password");
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.sendRedirect("/views/glogin.jsp");
    }
}
