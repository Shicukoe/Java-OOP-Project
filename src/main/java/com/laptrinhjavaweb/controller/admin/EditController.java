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

@WebServlet(urlPatterns = {"/admin-Chinh-sua-thong-tin"})
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 2686801510274002166L;

    @Inject
    iNewService NewService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        try {
            int id = Integer.parseInt(idParam);
            Pet pet = NewService.getPetById(id);
            if (pet != null) {
                request.setAttribute("pet", pet);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/editpage.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Pet not found");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Pet ID");
        }
    }
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = new Pet();
        pet.setId(Integer.parseInt(request.getParameter("id")));

        request.setCharacterEncoding("UTF-8");
        pet.setName(request.getParameter("name"));
        String priceStr = request.getParameter("price");
        if (priceStr != null && !priceStr.isEmpty()) {
            pet.setPrice(Double.valueOf(priceStr));
        } else {
            // Handle the case where price is missing or empty (e.g., set a default or throw an error)
            pet.setPrice(0.0); // Example default value
        }
        pet.setType(request.getParameter("type"));
        pet.setBreed(request.getParameter("breed"));
        pet.setAge(Integer.parseInt(request.getParameter("age")));
        pet.setGender(request.getParameter("gender"));
        pet.setDescription(request.getParameter("description"));
        pet.setAddedBy(request.getParameter("addedBy"));

            try {
            NewService.update(pet);
            response.sendRedirect(request.getContextPath() + "/admin-home");
        } catch (IOException e) {
            System.out.println("Failed to add pet at controller." + e.getMessage());
    }
    }
}

