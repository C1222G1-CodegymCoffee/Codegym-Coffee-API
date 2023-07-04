package com.example.codegym_coffee.controller.news;

import com.example.codegym_coffee.model.News;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@CrossOrigin("*")
public class NewsController {

    @Autowired
    private INewsService iNewsService;


    @GetMapping("/list-news")
    public ResponseEntity<Page<News>> showListNews(@PageableDefault(size = 5)Pageable pageable,
                                                   @RequestParam(value = "page", defaultValue = "0") int page) {
        pageable = PageRequest.of(page,5);
        Page<News> newsPage = iNewsService.findAllNews(pageable);
        if (newsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }
}
