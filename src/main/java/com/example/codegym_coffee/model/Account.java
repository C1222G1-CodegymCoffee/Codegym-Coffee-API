package com.example.codegym_coffee.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "account")
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_account")
    private Integer idAccount;

    @Column(name = "name_account",columnDefinition = "Varchar(40)")
    private String nameAccount;

    @Column(name = "password", columnDefinition = "Varchar(255)")
    private String password;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @OneToOne(mappedBy = "account")
    private Employee employee;


    public Account() {
    }

    

    public Account(Integer idAccount, String nameAccount, String password, Employee employee) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.password = password;
        this.employee = employee;
    }

    public Account(String nameAccount, String password, List<GrantedAuthority> grantList) {
        this.nameAccount = nameAccount;
        this.password = password;

    }


    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.nameAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
