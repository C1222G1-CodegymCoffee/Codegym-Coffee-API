package com.example.codegym_coffee.dto.news;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class NewsDTO implements Validator {
    private Integer id;
    @NotBlank(message = "không được để trống")
//    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "không được chứa ký tự đặc biệt")
    private String title;
    @NotBlank(message = "không được để trống")
    private String content;
    private Date dayPost;
    @NotBlank(message = "không được để trống")
    private String image;

    public NewsDTO() {
    }

    public NewsDTO(Integer id, String title, String content, Date day_post, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dayPost = day_post;
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

    public Date getDayPost() {
        return dayPost;
    }

    public void setDayPost(Date dayPost) {
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
