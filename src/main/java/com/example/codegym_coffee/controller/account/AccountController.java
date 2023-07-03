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
@RequestMapping("home/admin/employee/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @GetMapping("")
    public List<Account> showList() {
        return iAccountService.showList();
    }
    @PostMapping("")
    public void addNew(@RequestBody Account account) {
        iAccountService.addNewAccount(account.getNameAccount(),account.getPassword());
    }
    @GetMapping("/{nameAccount}")
    public ResponseEntity<Page<Account>> findByNameAccount(@RequestParam(value = "page", defaultValue = "0") int page, @PathVariable String nameAccount) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Account> listEmployee = iAccountService.findByNameAccount(nameAccount,pageable);
        if (listEmployee.isEmpty()) {
            return new ResponseEntity<>(listEmployee, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
}