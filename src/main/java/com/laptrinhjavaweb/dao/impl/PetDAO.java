package com.laptrinhjavaweb.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavaweb.dao.iPetDAO;
import com.laptrinhjavaweb.mapper.PetMapper;
import com.laptrinhjavaweb.model.Pet; 

public class PetDAO extends AbstractDAO<Pet> implements iPetDAO {

    @Override
    public List<Pet> getAllPets() {
        String sql = "SELECT * FROM PETS";  // SQL query to fetch all pets
        return query(sql, new PetMapper());
    }

    // Method to save a new pet to the database
    @Override
    public void addpet(Pet pet) {
        String sql = "INSERT INTO PETS (name, price, type, breed, age, gender, description, added_by) VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = connect();
        try { PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pet.getName());
            stmt.setDouble(2, pet.getPrice());
            stmt.setString(3, pet.getType());
            stmt.setString(4, pet.getBreed());
            stmt.setInt(5, pet.getAge());
            stmt.setString(6, pet.getGender());
            stmt.setString(7, pet.getDescription());
            stmt.setString(8, pet.getAddedBy());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Pet added successfully!");
            } else {
                System.out.println("Failed to add pet.");
            }     
        } catch (SQLException e) {
            System.out.println("Failed to add pet." + e.getMessage());
        }
    }


    @Override
    public void delete(Pet pet) {
        String sql = "DELETE FROM pets WHERE pet_id = ?";
        Connection conn = connect();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, pet.getId());
                stmt.executeUpdate();
                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Pet Deleted successfully!");
                } else {
                    System.out.println("Failed to delete pet.");
                }     
            } catch (SQLException e) {
                System.out.println("Failed to delete pet." + e.getMessage());
            }
        }


    @Override
    public void update(Pet pet) {
        String sql = " UPDATE PETS SET name = ?, price = ?, type = ?, breed = ?, age = ?, gender = ?, description = ?, added_by = ? WHERE pet_id = ?";
        Connection conn = connect();
        try { PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pet.getName());
            stmt.setDouble(2, pet.getPrice());
            stmt.setString(3, pet.getType());
            stmt.setString(4, pet.getBreed());
            stmt.setInt(5, pet.getAge());
            stmt.setString(6, pet.getGender());
            stmt.setString(7, pet.getDescription());
            stmt.setString(8, pet.getAddedBy());
            stmt.setInt(9, pet.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Pet updated successfully!");
            } else {
                System.out.println("Failed to update pet.");
            }     
        } catch (SQLException e) {
            System.out.println("Failed to update pet." + e.getMessage());
        }
           
    }
    
    @Override
       public Pet getPetById(int id) {
        Pet pet = new Pet();
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        Connection conn = connect();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pet = new Pet();
                    pet.setId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setPrice(rs.getDouble("price"));
                    pet.setType(rs.getString("type"));
                    pet.setBreed(rs.getString("breed"));
                    pet.setAge(rs.getInt("age"));
                    pet.setGender(rs.getString("gender"));
                    pet.setDescription(rs.getString("description"));
                    pet.setAddedBy(rs.getString("added_by"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to update pet." + e.getMessage());
        }
        return pet;
    }

    @Override
    public Pet getPetById(int id, String type) {
        Pet pet = new Pet();
        String sql = "SELECT * FROM pets WHERE pet_id = ? AND type = ?";
        Connection conn = connect();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, type);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pet = new Pet();
                    pet.setId(rs.getInt("pet_id"));
                    pet.setName(rs.getString("name"));
                    pet.setPrice(rs.getDouble("price"));
                    pet.setType(rs.getString("type"));
                    pet.setBreed(rs.getString("breed"));
                    pet.setAge(rs.getInt("age"));
                    pet.setGender(rs.getString("gender"));
                    pet.setDescription(rs.getString("description"));
                    pet.setAddedBy(rs.getString("added_by"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to update pet." + e.getMessage());
        }
        return pet;
    }


}
    



