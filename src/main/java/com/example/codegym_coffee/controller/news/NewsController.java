package com.example.codegym_coffee.controller.news;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class NewsController {

    @GetMapping("/admin/news")
    public ResponseEntity<?> getNews(){
        return ResponseEntity.ok().body("đây là trang admin");
    }
}
