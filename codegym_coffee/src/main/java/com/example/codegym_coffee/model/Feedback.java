package com.example.codegym_coffee.model;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "date")
    private String dayOfFeedback;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;
    @Column(columnDefinition = "Varchar(40)")
    private String creator;
    private String content;
    @Column(columnDefinition = "Varchar(40)")
    private String email;

    public Feedback() {
    }

    public Feedback(int id, String dayOfFeedback, String image, String creator, String content, String email) {
        this.id = id;
        this.dayOfFeedback = dayOfFeedback;
        this.image = image;
        this.creator = creator;
        this.content = content;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfFeedback() {
        return dayOfFeedback;
    }

    public void setDayOfFeedback(String dayOfFeedback) {
        this.dayOfFeedback = dayOfFeedback;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
