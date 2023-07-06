package com.example.codegym_coffee.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_news")
    private Integer idNews;

    @Column(name = "title",columnDefinition = "MEDIUMTEXT")
    private String title;

    @Column(name = "content",columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name = "day_post")
    private LocalDate dayPost;

    @Column(name = "image",columnDefinition = "MEDIUMTEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    private Employee employee;

    public News() {
    }

    public News(Integer idNews, String title, String content,
                LocalDate dayPost, String image, Employee employee) {
        this.idNews = idNews;
        this.title = title;
        this.content = content;
        this.dayPost = dayPost;
        this.image = image;
        this.employee = employee;
    }

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
