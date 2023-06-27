package com.example.codegym_coffee.dto.news;

public class NewsDTO {
    private Integer id;

    private String name;

    public NewsDTO() {
    }

    public NewsDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
