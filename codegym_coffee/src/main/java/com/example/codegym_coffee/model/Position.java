package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_position")
    private Integer idPosition;

    @Column(name = "name",columnDefinition = "Varchar(30)")
    private String name;

    public Position() {
    }

    public Position(Integer idPosition, String name) {
        this.idPosition = idPosition;
        this.name = name;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
