package com.example.codegym_coffee.dto.feedback;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class FeedbackDTO {

    private Integer idFeedback;
    private String codeFeedback;

    @NotBlank(message = "Khong duoc bo trong")
    @Pattern(regexp = "^(?=.*[a-zA-Z\\s])[^!@#$%^&*(),.?\":{}|<>]{4,100}$", message = "Ten khong hop le")
    @Size(min = 4, max = 99, message = "Ten phai co do dai ty 4 đến 99 ky tu")
    private String creator;

    @NotBlank(message = "khong duoc bo trong")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email khong hop le")
    @Size(min = 20, max = 99, message = "email phai co do dai ty 20 đến 99 ky tu")
    private String email;

    @NotBlank(message = "Khong duoc bo trong")
    @Size(min = 5, max = 200, message = "noi dung phai tu 5 ky tu va khong dai qua 200 ky tu")
    private String content;

    @NotBlank(message = "Khong duoc bo trong")
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

