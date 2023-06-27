package com.example.codegym_coffee.dto.feedback;

import java.time.LocalDate;

public class FeedbackDTO {

    private Integer idFeedback;
    private String codeFeedback;
    private String content;
    private String creator;
    private String email;

    private String image;

    private LocalDate dayOfFeedback;

    public FeedbackDTO() {
    }

    public FeedbackDTO(Integer idFeedback, String codeFeedback, String content,
                       String creator, String email, String image, LocalDate dayOfFeedback) {
        this.idFeedback = idFeedback;
        this.codeFeedback = codeFeedback;
        this.content = content;
        this.creator = creator;
        this.email = email;
        this.image = image;
        this.dayOfFeedback = dayOfFeedback;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getCodeFeedback() {
        return codeFeedback;
    }

    public void setCodeFeedback(String codeFeedback) {
        this.codeFeedback = codeFeedback;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public LocalDate getDayOfFeedback() {
        return dayOfFeedback;
    }

    public void setDayOfFeedback(LocalDate dayOfFeedback) {
        this.dayOfFeedback = dayOfFeedback;
    }
}

