package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    String query = "select * from user";
    String INSERT = "INSERT INTO user VALUES ";
    String DELETE = "DELETE FROM user WHERE id = ";
    String UPDATE = "UPDATE user ";
    String SET = " SET ";
    String WHERE = " WHERE ID = ";
    String USERNAME = "username = ";
    String PASSWORD = "password = ";
    String PHONE_NUMBER = "phone_number = ";
    List<User> userList;


    public List<User> getAllUsers(){
        try(Connection conn = ConnectionConfig.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            userList = new ArrayList<>();
            while (rs.next()) {
                userList.add(new User(rs.getInt("id"),rs.getString("username"),
                        rs.getString("password"),rs.getString("phone_number")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean addUser(int id, String username, String password, String phoneNumber){
        try(Connection conn = ConnectionConfig.getConnection();
            Statement stmt = conn.createStatement()) {
            String user_name = "'" + username + "'";
            String pass_word = "'" + password + "'";
            String phone_number = "'" + phoneNumber + "'";
            stmt.executeUpdate(INSERT + '(' + id + ',' + user_name + ',' + pass_word + ',' + phone_number + ");");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(int id){
        try(Connection conn = ConnectionConfig.getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(DELETE + id + ';');
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUsername(int id, String username){
        try(Connection conn = ConnectionConfig.getConnection();
            Statement stmt = conn.createStatement()) {
            String user_name = "'" + username + "'";
            stmt.executeUpdate(UPDATE + SET + USERNAME + user_name + WHERE + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(int id, String password){
        try(Connection conn = ConnectionConfig.getConnection();
            Statement stmt = conn.createStatement()) {
            String pass_word = "'" + password + "'";
            stmt.executeUpdate(UPDATE + SET + PASSWORD + pass_word + WHERE + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePhoneNumber(int id, String phoneNumber){
        try(Connection conn = ConnectionConfig.getConnection();
            Statement stmt = conn.createStatement()) {
            String phone_number = "'" + phoneNumber + "'";
            stmt.executeUpdate(UPDATE + SET + PHONE_NUMBER + phone_number + WHERE + id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
