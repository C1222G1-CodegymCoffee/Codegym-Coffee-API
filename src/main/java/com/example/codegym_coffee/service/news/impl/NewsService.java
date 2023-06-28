package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.model.News;
import com.example.codegym_coffee.repository.news.INewsRepository;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class NewsService implements INewsService {

    @Autowired
    private INewsRepository iNewsRepository;


    @Override
    public Page<News> findAllNews(Pageable pageable) {
        return iNewsRepository.findAllNews(pageable);
    }
}
