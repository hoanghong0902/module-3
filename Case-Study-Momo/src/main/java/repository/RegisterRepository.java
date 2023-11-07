package repository;

import entity.UserMomo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterRepository {
    String QUERY = "INSERT INTO USER_MOMO (USERNAME,PHONE_NUMBER,PASS_WORD,BANK_ACCOUNT_NUMBER) VALUES (?,?,?,?);";
    String QUERY1 = "SELECT PHONE_NUMBER FROM USER_MOMO;";
    String QUERY2 = "SELECT BANK_ACCOUNT_NUMBER FROM USER_MOMO;";
    public boolean registerUserMomo(UserMomo userMomo) throws SQLException, ClassNotFoundException{
        if(phoneNumberExist(userMomo.getPhoneNumber()) || !isBankAccountNumber(userMomo.getBankAccountNumber())){
            return false;
        }
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY)){
            pstmt.setString(1, userMomo.getUsername());
            pstmt.setString(2, userMomo.getPhoneNumber());
            pstmt.setString(3, userMomo.getPassword());
            pstmt.setString(4, userMomo.getBankAccountNumber());
            pstmt.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean phoneNumberExist(String phoneNumber){
        List<String> phone = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY1);
             ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                phone.add(rs.getString("phone_number"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        for (String phones : phone){
            if(phones.equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }
    public boolean isBankAccountNumber(String bankAccountNumber){
        List<String> bankAccount = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(QUERY2);
             ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                bankAccount.add(rs.getString("bank_account_number"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        for (String accounts : bankAccount){
            if(accounts.equals(bankAccountNumber)){
                return true;
            }
        }
        return false;
    }
}
