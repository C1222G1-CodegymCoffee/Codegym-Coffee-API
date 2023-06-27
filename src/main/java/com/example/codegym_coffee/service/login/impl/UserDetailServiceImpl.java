package com.example.codegym_coffee.service.login.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.AccountRole;
import com.example.codegym_coffee.repository.login.IAccountRepository;
import com.example.codegym_coffee.repository.login.IAccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IAccountRoleRepository accountRoleRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountRepository.findByAccountUser(username);
        if (account == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        List<AccountRole> accountRoles = this.accountRoleRepository.findByAccount(account);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (accountRoles != null) {
            for (AccountRole accountRole : accountRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(accountRole.getRole().getNameRole());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(account.getNameAccount(),
                account.getPassword(), grantList);

        return userDetails;
    }
}
