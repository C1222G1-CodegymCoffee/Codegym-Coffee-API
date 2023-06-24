package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
public class TableCoffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "Varchar(40)")
    private String name;

    public TableCoffee() {
    }

    public TableCoffee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
