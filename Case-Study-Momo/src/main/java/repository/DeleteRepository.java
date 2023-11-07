package repository;

import entity.UserMomo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRepository {
    String QUERY = "DELETE FROM USER_MOMO WHERE PHONE_NUMBER = ?";
    public boolean deleteUserMomo(String phoneNumber) throws SQLException, ClassNotFoundException{
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setString(1, phoneNumber);
            pstmt.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
