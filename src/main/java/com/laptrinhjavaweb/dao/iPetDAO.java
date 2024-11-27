package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.Pet;

public interface iPetDAO extends GenericDAO<Pet> {
    void addpet(Pet pet);
    List<Pet> getAllPets();
    void update(Pet pet);
    void delete(Pet pet);
    Pet getPetById(int id);
    Pet getPetById(int id, String type);
    // Pet getPetById(int petId);
    // boolean updatePet(Pet pet);
    // boolean deletePet(int petId);
}