package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewsService{
    Page<News> findAllNews(Pageable pageable);
}
