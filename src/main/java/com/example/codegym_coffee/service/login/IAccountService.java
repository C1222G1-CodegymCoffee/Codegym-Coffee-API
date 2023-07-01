package com.example.codegym_coffee.service.login;

import com.example.codegym_coffee.model.Account;

public interface IAccountService {
    void updateResetPasswordToken(String token, String email);
    Account getByResetPasswordToken(String token);

    void updatePassword(Account account, String newPassword);

    Account findByEmail(String userEmail);
}