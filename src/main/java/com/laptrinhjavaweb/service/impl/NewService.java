package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.iPetDAO;
import com.laptrinhjavaweb.model.Pet;
import com.laptrinhjavaweb.service.iNewService;

public class NewService implements iNewService {

    @Inject
    private iPetDAO petDAO;

    @Override
    public void addpet(Pet pet) {
        petDAO.addpet(pet);
    }

    @Override
    public List<Pet> getAllPets() {
            return petDAO.getAllPets();
        }
    
    @Override
    public void update(Pet pet) {
        petDAO.update(pet);
    }

    @Override
    public void delete(Pet pet) {
        petDAO.delete(pet);
    }

    @Override
    public Pet getPetById(int id){
        return petDAO.getPetById(id);
    }

    @Override
    public Pet getPetById(int id,String type) {
        return petDAO.getPetById(id, type);
    }

}
