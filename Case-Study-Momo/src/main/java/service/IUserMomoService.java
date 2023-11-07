package service;

import entity.UserMomo;

import java.sql.SQLException;

public interface IUserMomoService {
    UserMomo loginUser(String phoneNumber, String password) throws SQLException, ClassNotFoundException;
    boolean registerUser(String userName, String phoneNumber, String password, String bank_account_number) throws SQLException, ClassNotFoundException;
    boolean editUSer(String userName, String phoneNumber, String password, String bank_account_number) throws SQLException, ClassNotFoundException;
    boolean deleteUser(String phoneNumber) throws SQLException, ClassNotFoundException;
    UserMomo getUser(String phoneNumber) throws SQLException, ClassNotFoundException;
}
