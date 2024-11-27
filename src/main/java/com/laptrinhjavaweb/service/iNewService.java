package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.Pet;

public interface iNewService {
        List<Pet> getAllPets();
        void addpet(Pet pet);
        void update(Pet pet);
        void delete(Pet pet);
        Pet getPetById(int id);
        Pet getPetById(int id, String type);

}
