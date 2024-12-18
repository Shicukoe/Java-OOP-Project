package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.Pet;
import com.laptrinhjavaweb.service.iNewService;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
    @Inject
    private iNewService NewService;

    private static final long serialVersionUID = 2686801510274002166L;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.ManagePage(request,response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    private void ManagePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet petList = new Pet();
        petList.setListResult(NewService.getAllPets());
        request.setAttribute("petList",petList);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
			rd.forward(request, response);
    }   

    
}
