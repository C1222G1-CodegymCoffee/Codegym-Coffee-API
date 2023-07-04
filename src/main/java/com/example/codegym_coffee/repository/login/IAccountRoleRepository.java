package com.example.codegym_coffee.repository.login;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer> {
    List<AccountRole> findByAccount(Account account);
}
