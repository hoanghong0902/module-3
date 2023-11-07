package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

    static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    static final String USER = "root";
    static final String PASS = "piitiamo1702";

    public static Connection getConnection() throws SQLException {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
