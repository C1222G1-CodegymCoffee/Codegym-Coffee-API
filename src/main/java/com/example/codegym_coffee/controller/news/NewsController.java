package com.example.codegym_coffee.controller.news;

import com.example.codegym_coffee.model.News;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class NewsController {

    @Autowired
    private INewsService iNewsService;


    @GetMapping("/list-news")
    public ResponseEntity<List<News>> showListNews() {
        List<News> newsList = iNewsService.findAllNews();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }
}
