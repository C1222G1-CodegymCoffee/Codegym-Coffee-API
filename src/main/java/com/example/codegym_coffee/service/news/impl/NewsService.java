package com.example.codegym_coffee.service.news.impl;

import com.example.codegym_coffee.model.News;
import com.example.codegym_coffee.repository.news.INewsRepository;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class NewsService implements INewsService {

    @Autowired
    private INewsRepository iNewsRepository;

    @Override
    public List<News> findAllNews() {
        return iNewsRepository.findAlNews();
    }
}
