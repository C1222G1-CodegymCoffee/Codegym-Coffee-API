package com.example.codegym_coffee.dto.news;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NewsDTO implements Validator {
    private Integer id;
    @NotBlank(message = "không được để trống")
//    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "không được chứa ký tự đặc biệt")
    private String title;
    @NotBlank(message = "không được để trống")
    private String content;
    private LocalDate dayPost;
    @NotBlank(message = "không được để trống")
    private String image;

    public NewsDTO() {
    }

    public NewsDTO(Integer id, String title, String content, LocalDate dayPost, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dayPost = dayPost;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDayPost() {
        return dayPost;
    }

    public void setDayPost(LocalDate dayPost) {
        this.dayPost = dayPost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }


}
