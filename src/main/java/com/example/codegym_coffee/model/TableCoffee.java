package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "table_coffee")
public class TableCoffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_table")
    private Integer idTable;

    @Column(name = "name_table",columnDefinition = "Varchar(40)")
    private String nameTable;

    @Column(name = "status")
    private int status;

    @OneToOne(mappedBy = "tableCoffee")
    private Bill bill;

    public TableCoffee() {
    }


    public TableCoffee(Integer idTable, String nameTable, int status, Bill bill) {
        this.idTable = idTable;
        this.nameTable = nameTable;
        this.status = status;
        this.bill = bill;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
