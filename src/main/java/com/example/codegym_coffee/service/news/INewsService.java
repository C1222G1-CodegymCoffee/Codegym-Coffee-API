package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.model.News;

import java.util.List;

public interface INewsService{
    List<News> findAllNews();
}
