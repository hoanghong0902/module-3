package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/momo";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "piitiamo1702";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
