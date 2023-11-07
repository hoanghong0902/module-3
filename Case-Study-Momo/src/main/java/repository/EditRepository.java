package repository;

import entity.UserMomo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditRepository {
    String QUERY = "UPDATE USER_MOMO SET USERNAME = ?, PASS_WORD = ?, BANK_ACCOUNT_NUMBER = ? WHERE PHONE_NUMBER = ?";
    public boolean editUserMomo(UserMomo userMomo) throws SQLException, ClassNotFoundException{
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setString(1, userMomo.getUsername());
            pstmt.setString(2, userMomo.getPassword());
            pstmt.setString(3, userMomo.getBankAccountNumber());
            pstmt.setString(4, userMomo.getPhoneNumber());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
