package com.example.codegym_coffee.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback")
    private Integer idFeedback;

    @Column(name = "code_feedback",columnDefinition = "Varchar(40)")
    private String codeFeedback;

    @Column(name = "day_of_feedback")
    private LocalDate dayOfFeedback;

    @Column(name = "email", columnDefinition = "Varchar(40)")
    private String email;

    @Column(name = "image",columnDefinition = "MEDIUMTEXT")
    private String image;

    @Column(name = "creator",columnDefinition = "Varchar(40)")
    private String creator;

    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;


    public Feedback() {
    }

    public Feedback(Integer idFeedback, String codeFeedback, LocalDate dayOfFeedback,
                    String email, String image, String creator, String content) {
        this.idFeedback = idFeedback;
        this.codeFeedback = codeFeedback;
        this.dayOfFeedback = dayOfFeedback;
        this.email = email;
        this.image = image;
        this.creator = creator;
        this.content = content;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public LocalDate getDayOfFeedback() {
        return dayOfFeedback;
    }

    public void setDayOfFeedback(LocalDate dayOfFeedback) {
        this.dayOfFeedback = dayOfFeedback;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCodeFeedback() {
        return codeFeedback;
    }

    public void setCodeFeedback(String codeFeedback) {
        this.codeFeedback = codeFeedback;
    }
}
