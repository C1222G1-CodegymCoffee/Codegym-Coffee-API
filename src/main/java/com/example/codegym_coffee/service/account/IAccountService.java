package com.example.codegym_coffee.service.account;

import com.example.codegym_coffee.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    List<Account> showList();
    void addNewAccount(String nameAccount,String password);
    Page<Account> findByNameAccount(String nameAccount, Pageable pageable);
}
