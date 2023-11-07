package entity;

public class UserBank {
    private String userName;
    private String accountNumber;
    private String bankName;
    private long money;

    public UserBank(String userName, String accountNumber, String bankName, long money) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
