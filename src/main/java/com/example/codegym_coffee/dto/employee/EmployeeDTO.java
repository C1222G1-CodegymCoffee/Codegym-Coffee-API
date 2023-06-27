package com.example.codegym_coffee.dto.employee;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Position;

import java.time.LocalDate;

public class EmployeeDTO {
    private Integer idEmployee;
    private Boolean gender;
    private LocalDate dateOfBirth;
    private double salary;
    private String image;
    private String nameEmployee;
    private String address;
    private String phoneNumber;
    private String email;
    private Position position;
    private Account account;

    // Constructors, getters, and setters

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer idEmployee, Boolean gender, LocalDate dateOfBirth, double salary, String image, String nameEmployee, String address, String phoneNumber, String email, Position position, Account account) {
        this.idEmployee = idEmployee;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.image = image;
        this.nameEmployee = nameEmployee;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.account = account;
    }

    // Getters and Setters

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

