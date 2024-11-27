package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
        public Connection connect() {
            // URL format for Oracle database
            
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "shicukoe";
            String password = "Tus1234";

        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection succeeded");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }

        return conn;
    }

        @SuppressWarnings("hiding")
        @Override
        public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
            List<T> petList = new ArrayList<>();
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                conn = connect();
                stmt = conn.prepareStatement(sql);
                //set parameter
                rs = stmt.executeQuery();
                while(rs.next()) {
                    petList.add(rowMapper.mapRow(rs));
                }
                return petList;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    return null;
                }
            }
        }

}
