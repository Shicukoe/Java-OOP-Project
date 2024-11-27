package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.Users;

public interface iUserDAO {
    Users getUserByUsernameAndPassword(String username, String password);
}
