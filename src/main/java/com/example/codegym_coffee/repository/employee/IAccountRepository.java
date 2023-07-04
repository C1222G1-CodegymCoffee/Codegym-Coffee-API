//package com.example.codegym_coffee.repository.employee;
//
//import com.example.codegym_coffee.model.Account;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//public interface IAccountRepository extends JpaRepository<Account, Integer> {
//
//    @Modifying
//    @Transactional
//    @Query(value = "insert into account(name_account , password) values (:name_account , :password)", nativeQuery = true)
//    void createAccount(@Param("name_account") String nameAccount
//            , @Param("password") String password);
//
//    @Query(value = "select * from account", nativeQuery = true)
//    List<Account> accountList();
//
//
//    @Query(value = "select * from account where name_account = :nameAccount",nativeQuery = true)
//    Account findByName (String nameAccount);
//
//
//    @Query(value = "select * from account where name_account like %:name_account%", nativeQuery = true)
//    Page<Account> findAccountUserByNameAccount(@Param("name_account") String nameAccount, Pageable pageable);
//}
