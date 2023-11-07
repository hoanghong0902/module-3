package com.example.demojspservlet.service;

import com.example.demojspservlet.entity.User;
import com.example.demojspservlet.repository.LoginRepository;

import java.sql.SQLException;

public class LoginService {

    private LoginRepository loginRepository;

    public LoginService(){
        loginRepository = new LoginRepository();
    }
    public User login(String username, String password) throws SQLException {
        // B1: tim user co username = tiendeptrai
        User user = loginRepository.getUserByUserName(username);

        // B2: lay password ra
        String pass = user.getPassword();

        // B3: so sanh password
        if(pass.equals(password)){
            return user;
        }
        return null;
    }
}
