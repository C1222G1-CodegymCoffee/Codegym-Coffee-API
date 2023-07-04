//package com.example.codegym_coffee.service.account.impl;
//
//import com.example.codegym_coffee.model.Account;
//import com.example.codegym_coffee.repository.account.IAccountRepositoryQuynh;
//import com.example.codegym_coffee.service.account.IAccountServiceQuynh;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountServiceQuynh implements IAccountServiceQuynh {
//    @Autowired
//    private IAccountRepositoryQuynh iAccountRepository;
//
//    /**
//     /**
//     * Author:QuynhHTN
//     * Date create: 27/06/2023
//     * Function: use findByNameAccount method to find account
//     * @param nameAccount
//     * @return
//     */
//    @Override
//    public Account findByNameAccount(String nameAccount) {
//        return iAccountRepository.findByNameAccount(nameAccount);
//    }
//
//    /**
//     * Author:QuynhHTN
//     * Date create: 27/06/2023
//     * Function: use the changePassword method to user change password
//     * @param account
//     * @param newPassword
//     */
//    @Override
//    public void changePassword(Account account, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        account.setPassword(encodedPassword);
//        iAccountRepository.updatePassword(account.getPassword(),account.getIdAccount());
//    }
//
//    /**
//     * Author:QuynhHTN
//     * Date create: 27/06/2023
//     * Function: use the checkIfValidOldPassword method to check the old password match the new password
//     * @param account
//     * @param oldPassword
//     * @return
//     */
//    @Override
//    public Boolean checkIfValidOldPassword(Account account, String oldPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(oldPassword,account.getPassword());
//    }
//
//}
