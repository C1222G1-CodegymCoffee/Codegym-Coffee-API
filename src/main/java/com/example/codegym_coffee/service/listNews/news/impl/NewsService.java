package com.example.codegym_coffee.service.listNews.news.impl;

import com.example.codegym_coffee.dto.news.NewsDTO;
import com.example.codegym_coffee.repository.news.INewsRepository;
import com.example.codegym_coffee.service.listNews.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Service
public class NewsService implements INewsService {
    /**
     * create by : ThongDM ,
     * Date Create : 27/06/2023
     * Function : Add new 1 news to db
     *
     * @param newsDTO
     * @return no return value
     */
    @Autowired
    private INewsRepository repository;


    @Override
    public void addNews(NewsDTO newsDTO) {
        repository.addNews(newsDTO.getTitle(),newsDTO.getContent(),newsDTO.getDayPost(),newsDTO.getImage(),1);
    }
}
