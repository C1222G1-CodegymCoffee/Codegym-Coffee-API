package com.example.codegym_coffee.service.account.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.repository.account.IAccountRepository;
import com.example.codegym_coffee.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

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
        return iAccountRepository.findByNameAccount(nameAccount);
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
        account.setPassword(newPassword);
        iAccountRepository.updatePassword(account.getPassword(),account.getIdAccount());
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
        return account.getPassword().equals(oldPassword);
    }

}
