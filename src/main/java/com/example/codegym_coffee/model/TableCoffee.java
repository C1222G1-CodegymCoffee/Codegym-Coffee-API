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
    private Boolean status;

    public TableCoffee() {
    }

    public TableCoffee(Integer idTable, String nameTable, Boolean status) {
        this.idTable = idTable;
        this.nameTable = nameTable;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
