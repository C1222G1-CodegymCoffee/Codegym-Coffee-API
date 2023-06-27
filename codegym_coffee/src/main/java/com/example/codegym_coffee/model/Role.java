package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "name_role",columnDefinition = "Varchar(40)")
    private String nameRole;

    public Role() {
    }

    public Role(Integer idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
