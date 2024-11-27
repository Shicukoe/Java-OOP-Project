package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptrinhjavaweb.dao.iUserDAO;
import com.laptrinhjavaweb.model.Users;


@WebServlet(urlPatterns = {"/dang-nhap"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 2686801510274002166L;
    
    @Inject 
    private iUserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response);
		}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Validate user credentials
            Users user = userDAO.getUserByUsernameAndPassword(username, password);

            if (user != null) {
                // Credentials are valid: set user in session and redirect to dashboard
                HttpSession session = request.getSession();
                session.setAttribute("loggedUser", user);

                // Redirect to the dashboard or home page
                response.sendRedirect(request.getContextPath() + "/admin-home");
            } else {
                // Invalid credentials: set error message and return to login page
                request.setAttribute("errorMessage", "Invalid username or password!");
                request.getRequestDispatcher("/views/web/login.jsp").forward(request, response);
            }
        } catch (IOException e) {
            throw new ServletException("Error during login process", e);
        }
    }
}
