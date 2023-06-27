package com.example.codegym_coffee.dto.account;

public class AccountDTO {
    private Integer idAccount;
    private String nameAccount;
    private String password;

    public AccountDTO() {
    }

    public AccountDTO(Integer idAccount, String nameAccount, String password) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.password = password;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
