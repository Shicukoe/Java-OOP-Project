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

@WebServlet(urlPatterns = {"/admin-Them-thu-cung"})
public class AddController extends HttpServlet {
    private static final long serialVersionUID = 2686801510274002166L;

    @Inject
    private iNewService NewService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/create.jsp");
			rd.forward(request, response);     
        

    }
    
    @Override
    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
        Pet petAdd = new Pet();
        request.setCharacterEncoding("UTF-8");
        petAdd.setName(request.getParameter("name"));
        String priceStr = request.getParameter("price");
        if (priceStr != null && !priceStr.isEmpty()) {
            petAdd.setPrice(Double.parseDouble(priceStr));
        } else {
            // Handle the case where price is missing or empty (e.g., set a default or throw an error)
            petAdd.setPrice(0.0); // Example default value
        }
        petAdd.setType(request.getParameter("type"));
        petAdd.setBreed(request.getParameter("breed"));
        petAdd.setAge(Integer.parseInt(request.getParameter("age")));
        petAdd.setGender(request.getParameter("gender"));
        petAdd.setDescription(request.getParameter("description"));
        petAdd.setAddedBy(request.getParameter("addedBy"));

        try {
            NewService.addpet(petAdd);
            response.sendRedirect(request.getContextPath() + "/admin-home");
        } catch (IOException e) {
            System.out.println("Failed to add pet at controller." + e.getMessage());
    }
   
    }
}