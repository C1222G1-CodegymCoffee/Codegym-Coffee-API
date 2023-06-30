package com.example.codegym_coffee.controller.account;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("home/admin/employee/account")
@CrossOrigin

public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @GetMapping("")
    public List<Account> showList() {
        return iAccountService.showList();
    }
}
