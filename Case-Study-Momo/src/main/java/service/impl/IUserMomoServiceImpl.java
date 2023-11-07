package service.impl;

import entity.UserMomo;
import repository.*;
import service.IUserMomoService;
import service.builder.UserMomoBuilder;

import java.sql.SQLException;

public class IUserMomoServiceImpl implements IUserMomoService {

    private LoginRepository loginRepository;
    private EditRepository editRepository;
    private RegisterRepository registerRepository;
    private DeleteRepository deleteRepository;
    private GetUserMomoRepository getUserMomoRepository;

    public IUserMomoServiceImpl() {
        this.loginRepository = new LoginRepository();
        this.editRepository = new EditRepository();
        this.registerRepository = new RegisterRepository();
        this.deleteRepository = new DeleteRepository();
        this.getUserMomoRepository = new GetUserMomoRepository();
    }

    @Override
    public UserMomo loginUser(String phoneNumber, String password) throws SQLException, ClassNotFoundException {
        UserMomo userMomo = new UserMomoBuilder()
                .withPhoneNumber(phoneNumber)
                .withPassword(password)
                .builder();
        return loginRepository.getUserMomo(userMomo);
    }

    @Override
    public boolean registerUser(String userName, String phoneNumber, String password, String bank_account_number) throws SQLException, ClassNotFoundException {
        UserMomo userMomo = new UserMomoBuilder()
                .withUserName(userName)
                .withPhoneNumber(phoneNumber)
                .withPassword(password)
                .withBankAccountNumber(bank_account_number)
                .builder();
        return registerRepository.registerUserMomo(userMomo);
    }

    @Override
    public boolean editUSer(String userName, String phoneNumber, String password, String bank_account_number) throws SQLException, ClassNotFoundException {
        UserMomo userMomo = new UserMomoBuilder()
                .withUserName(userName)
                .withPhoneNumber(phoneNumber)
                .withPassword(password)
                .withBankAccountNumber(bank_account_number)
                .builder();
        return editRepository.editUserMomo(userMomo);
    }

    @Override
    public boolean deleteUser(String phoneNumber) throws SQLException, ClassNotFoundException {
        return deleteRepository.deleteUserMomo(phoneNumber);
    }

    @Override
    public UserMomo getUser(String phoneNumber) throws SQLException, ClassNotFoundException {
        return getUserMomoRepository.getUserMomo(phoneNumber);
    }
}
