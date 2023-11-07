package repository;

import entity.UserMomo;
import service.builder.UserMomoBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {
    String QUERY = "SELECT * FROM USER_MOMO WHERE PHONE_NUMBER = ?";
    public UserMomo getUserMomo(UserMomo userMomo) throws SQLException, ClassNotFoundException{
        UserMomo userResult = null;
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setString(1, userMomo.getPhoneNumber());
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                userResult = new UserMomoBuilder()
                        .withUserName(resultSet.getString("username"))
                        .withPhoneNumber(resultSet.getString("phone_number"))
                        .withPassword(resultSet.getString("pass_word"))
                        .withBankAccountNumber(resultSet.getString("bank_account_number"))
                        .withMoney(resultSet.getLong("money"))
                        .builder();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userResult;
    }
}
