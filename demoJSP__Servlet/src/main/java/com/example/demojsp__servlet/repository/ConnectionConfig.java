package com.example.demojsp__servlet.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "piitiamo1702";

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
