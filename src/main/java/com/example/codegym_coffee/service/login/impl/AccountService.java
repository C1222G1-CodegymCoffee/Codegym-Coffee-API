package com.example.codegym_coffee.service.login.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.repository.login.IAccountRepository;
import com.example.codegym_coffee.service.login.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public void updateResetPasswordToken(String token, String email) {
        Account account = accountRepository.findByEmail(email);
        if (account != null) {
            account.setResetPasswordToken(token);
            accountRepository.save(account);
        } else {
            try {
                throw new AccountNotFoundException("Email " + email + " không tồn tại");
            } catch (AccountNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Account getByResetPasswordToken(String token) {
        return accountRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(Account account, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        account.setPassword(encodedPassword);

        account.setResetPasswordToken(null);
        accountRepository.save(account);
    }

    @Override
    public Account findByEmail(String userEmail) {
        return accountRepository.findByEmail(userEmail);
    }
}
