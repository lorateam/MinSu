package model;

public class user {
    private int account;
    private int password;
    String name;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {

        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
