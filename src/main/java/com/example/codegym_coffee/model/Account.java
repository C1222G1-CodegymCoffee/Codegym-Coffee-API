package com.example.codegym_coffee.model;


import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
