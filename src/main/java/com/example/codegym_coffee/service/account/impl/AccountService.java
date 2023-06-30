package com.example.codegym_coffee.service.account.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.repository.employee.IAccountRepository;
import com.example.codegym_coffee.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public List<Account> showList() {
        return iAccountRepository.accountList();
    }
}
