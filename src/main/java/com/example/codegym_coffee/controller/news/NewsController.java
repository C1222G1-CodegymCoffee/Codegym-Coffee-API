package com.example.codegym_coffee.controller.news;

import com.example.codegym_coffee.dto.news.NewsDTO;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.codegym_coffee.model.News;
import com.example.codegym_coffee.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@CrossOrigin("*")
public class NewsController {
    @Autowired
    private INewsService iNewsService;
    /**
     * create by : ThongDM ,
     * Date Create : 27/06/2023
     * Function : add 1 new news to the database
     *
     * @param newsDTO
     * @return HttpStatus.BAD_REQUEST if the result is an error or HttpStatus.OK if the passed parameter is successfully saved to the database
     */
    @PostMapping()
    public ResponseEntity<List<ObjectError>> createNews(@Validated @RequestBody NewsDTO newsDTO, BindingResult bindingResult) {
        newsDTO.validate(newsDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iNewsService.addNews(newsDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<News>> showListNews(@PageableDefault(size = 5)Pageable pageable,
                                                   @RequestParam(value = "page", defaultValue = "0") int page) {
        pageable = PageRequest.of(page,5);
        Page<News> newsPage = iNewsService.findAllNews(pageable);
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }
}

