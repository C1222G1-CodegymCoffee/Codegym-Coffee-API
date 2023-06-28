package com.example.codegym_coffee.repository.login;

import com.example.codegym_coffee.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByNameAccount(String username);

    @Query(value = "SELECT * FROM account a join employee e on a.id_account = e.id_account WHERE e.email = ?1", nativeQuery = true)
    public Account findByEmail(String email);

    public Account findByResetPasswordToken(String token);
}
