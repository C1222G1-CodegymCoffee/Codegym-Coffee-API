package com.example.codegym_coffee.dto.accountDTO;

public class AuthResponse {

    private String nameAccount;
    private String accessToken;

    public AuthResponse() { }

    public AuthResponse(String nameAccount, String accessToken) {
        this.nameAccount = nameAccount;
        this.accessToken = accessToken;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
