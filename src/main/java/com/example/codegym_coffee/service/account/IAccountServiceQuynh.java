package com.example.codegym_coffee.service.account;

import com.example.codegym_coffee.model.Account;

public interface IAccountServiceQuynh {
    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findByNameAccount method to find account
     * @param nameAccount
     * @return
     */
    Account findByNameAccount(String nameAccount);

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the changePassword method to user change password
     * @param account
     * @param newPassword
     */
    void changePassword(Account account, String newPassword);

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the checkIfValidOldPassword method to check the old password match the new password
     * @param account
     * @param oldPassword
     * @return
     */
    Boolean checkIfValidOldPassword(Account account, String oldPassword);
}
