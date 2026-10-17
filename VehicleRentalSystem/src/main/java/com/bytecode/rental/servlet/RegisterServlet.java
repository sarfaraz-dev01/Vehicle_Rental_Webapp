package com.bytecode.rental.servlet;

import java.io.IOException;

import com.bytecode.rental.dao.UserDAO;
import com.bytecode.rental.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");

        User user = new User(
                name,
                email,
                password,
                mobile
        );

        UserDAO dao = new UserDAO();

        boolean result = dao.registerUser(user);

        response.setContentType("text/html");

        if (result) {

            response.getWriter().println(
                "<h2>Registration Successful!</h2>"
            );

            response.getWriter().println(
                "<a href='login.html'>Login Now</a>"
            );

        } else {

            response.getWriter().println(
                "<h2>Registration Failed!</h2>"
            );

            response.getWriter().println(
                "<a href='register.html'>Try Again</a>"
            );
        }
    }
}