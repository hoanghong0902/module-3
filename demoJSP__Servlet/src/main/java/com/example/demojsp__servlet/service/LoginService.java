package com.example.demojsp__servlet.service;


import com.example.demojsp__servlet.entity.User;
import com.example.demojsp__servlet.repository.LoginRepository;

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
