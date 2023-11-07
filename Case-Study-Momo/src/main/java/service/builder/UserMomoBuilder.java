package service.builder;

import entity.UserMomo;

public class UserMomoBuilder {
    private String userName;
    private String phoneNumber;
    private String password;
    private String bankAccountNumber;
    private long money;

    public UserMomoBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserMomoBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserMomoBuilder withBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }
    public UserMomoBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserMomoBuilder withMoney(long money) {
        this.money = money;
        return this;
    }
    public UserMomo builder() {
        return new UserMomo(userName,phoneNumber,password,bankAccountNumber,money);
    }
}
