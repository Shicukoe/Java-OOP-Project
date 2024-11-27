package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.Pet;
import com.laptrinhjavaweb.service.iNewService;

@WebServlet(urlPatterns = {"/admin-delete"})
public class DeleteController extends HttpServlet {
    @Inject
    private iNewService NewService;

    private static final long serialVersionUID = 2686801510274002166L;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Pet pet = new Pet();
            pet.setId(Integer.parseInt(request.getParameter("id")));
            try {
                NewService.delete(pet);
                response.sendRedirect(request.getContextPath() + "/admin-home");
            } catch (IOException e) {
                System.out.println("Failed to delete pet at controller." + e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }



    
}

