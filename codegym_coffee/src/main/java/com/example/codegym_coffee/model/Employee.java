package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Boolean gender;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    private double salary;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;
    @Column(columnDefinition = "Varchar(40)")
    private String name;
    @Column(columnDefinition = "Varchar(40)")
    private String address;
    @Column(columnDefinition = "Varchar(15)")
    private String phoneNumber;
    @Column(columnDefinition = "Varchar(40)")
    private String email;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Employee() {
    }

    public Employee(int id, Boolean gender, String dateOfBirth, double salary, String image, String name, String address, String phoneNumber, String email, Position position, Account account) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.image = image;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
