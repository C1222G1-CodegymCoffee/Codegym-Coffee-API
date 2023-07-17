package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.dto.news.NewsDTO;
import com.example.codegym_coffee.model.News;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface INewsService{
    void addNews (NewsDTO newsDTO);
   

    Page<News> findAllNews(Pageable pageable);

    
    News findByIdNews(int id);
}
