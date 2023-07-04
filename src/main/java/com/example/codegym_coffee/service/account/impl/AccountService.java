package com.example.codegym_coffee.service.account.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.repository.account.IAccountRepositoryQuynh;
import com.example.codegym_coffee.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepositoryQuynh accountRepositoryQuynh;

    @Override
    public List<Account> showList() {
        return accountRepositoryQuynh.accountList();
    }

    @Override
    public Account saveAccountUser(Account accountUser) {
        return accountRepositoryQuynh.save(accountUser);
    }

    @Override
    public Page<Account> findAccountUserByNameAccount(String name,Pageable pageable) {
        return accountRepositoryQuynh.findAccountUserByNameAccount(name,pageable);
    }

    /**
     /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findByNameAccount method to find account
     * @param nameAccount
     * @return
     */
    @Override
    public Account findByNameAccount(String nameAccount) {
        return accountRepositoryQuynh.findByNameAccount(nameAccount);
    }

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the changePassword method to user change password
     * @param account
     * @param newPassword
     */
    @Override
    public void changePassword(Account account, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        account.setPassword(encodedPassword);
        accountRepositoryQuynh.updatePassword(account.getPassword(),account.getIdAccount());
    }

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the checkIfValidOldPassword method to check the old password match the new password
     * @param account
     * @param oldPassword
     * @return
     */
    @Override
    public Boolean checkIfValidOldPassword(Account account, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(oldPassword,account.getPassword());
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {
        Account account = accountRepositoryQuynh.findByEmail(email);
        if (account != null) {
            account.setResetPasswordToken(token);
            accountRepositoryQuynh.save(account);
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
        return accountRepositoryQuynh.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(Account account, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        account.setPassword(encodedPassword);
        account.setResetPasswordToken(null);
        accountRepositoryQuynh.save(account);
    }

    @Override
    public Account findByEmail(String userEmail) {
        return accountRepositoryQuynh.findByEmail(userEmail);
    }

}
