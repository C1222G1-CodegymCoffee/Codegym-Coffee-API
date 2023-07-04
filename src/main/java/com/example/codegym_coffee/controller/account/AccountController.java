package com.example.codegym_coffee.controller.account;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("api/admin/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @GetMapping("")
    public List<Account> showList() {
        return iAccountService.showList();
    }

    @GetMapping("/{nameAccount}")
    public ResponseEntity<?> findByNameAccount(@RequestParam(value = "page", defaultValue = "0") int page, @PathVariable String nameAccount) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Account> listAccount = iAccountService.findAccountUserByNameAccount(nameAccount,pageable);
        if (listAccount.isEmpty()) {
            return new ResponseEntity<>(listAccount, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listAccount, HttpStatus.OK);
    }
}
