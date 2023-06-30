package com.example.codegym_coffee.repository.employee;

import com.example.codegym_coffee.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "select * from account",nativeQuery = true)
    List<Account> accountList();
}
