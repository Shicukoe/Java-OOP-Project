package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.dao.iUserDAO;
import com.laptrinhjavaweb.model.Users;

public class UserDAO extends AbstractDAO<Users> implements iUserDAO {
    @Override
    public Users getUserByUsernameAndPassword(String username, String password) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            Users user = null;
            Connection conn = connect();    
           try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new Users();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));

            }
        }
        } catch (SQLException e) {
            System.out.println("Failed to update user." + e.getMessage());
        }
        return user;
    }
}

