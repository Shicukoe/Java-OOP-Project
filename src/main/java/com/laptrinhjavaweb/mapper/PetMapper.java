package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.Pet;

public class PetMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs) {
        try {
            Pet pet = new Pet();
            pet.setId(rs.getInt("pet_id"));
            pet.setName(rs.getString("name"));
            pet.setPrice(rs.getDouble("price"));
            pet.setType(rs.getString("type"));
            pet.setBreed(rs.getString("breed"));
            pet.setAge(rs.getInt("age"));
            pet.setGender(rs.getString("gender"));
            pet.setDescription(rs.getString("description"));
            pet.setAddedBy(rs.getString("added_by"));
            return pet;
        } catch (SQLException e) {
            return null;
        }
    }


}
