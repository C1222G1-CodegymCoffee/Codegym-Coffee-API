package com.example.codegym_coffee.repository.login;

import com.example.codegym_coffee.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountUser(String username);
}
