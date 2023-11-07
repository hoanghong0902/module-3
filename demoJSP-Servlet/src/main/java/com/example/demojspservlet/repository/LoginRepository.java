package com.example.demojspservlet.repository;

import com.example.demojspservlet.entity.User;

import java.sql.*;

public class LoginRepository {
    public User getUserByUserName(String username) throws SQLException {
        User user = new User();
        Connection conn = ConnectionConfig.getConnection();
        PreparedStatement stmt = null;
        try {
            String query = "SELECT * FROM USER WHERE USERNAME = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
        }
        return user;
    }
}
