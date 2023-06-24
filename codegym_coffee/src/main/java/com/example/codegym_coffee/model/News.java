package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    @Column(columnDefinition = "date")
    private String dayPost;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;
    @Column(columnDefinition = "Varchar(30)")
    private String title;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public News() {
    }

    public News(int id, String content, String dayPost, String image, String title, Employee employee) {
        this.id = id;
        this.content = content;
        this.dayPost = dayPost;
        this.image = image;
        this.title = title;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDayPost() {
        return dayPost;
    }

    public void setDayPost(String dayPost) {
        this.dayPost = dayPost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
