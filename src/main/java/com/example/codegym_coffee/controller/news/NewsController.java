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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class NewsController {

    @Autowired
    private INewsService iNewsService;

    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * @param pageable
     * return : list News, status Ok
     */

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

    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * @param id
     * return : idNews
     */
    @GetMapping("/detail-news/{id}")
    public ResponseEntity<News> getInfoNews (@PathVariable Integer id) {

        News news = this.iNewsService.findByIdNews(id);

        if (news == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
