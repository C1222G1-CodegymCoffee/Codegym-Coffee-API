package com.example.codegym_coffee.repository.account;

import com.example.codegym_coffee.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findByNameAccount method to find account
     * @param nameAccount
     * @return
     */
    @Query(value = "SELECT * from account where name_account = :nameAccount",nativeQuery = true)
    Account findByNameAccount(String nameAccount);

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the updatePasswword method to user change password
     * @param newPassword
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE account SET password = :newPassword WHERE id_account = :id",nativeQuery = true)
    void updatePassword(@Param("newPassword")String newPassword, @Param("id")Integer id);
}
