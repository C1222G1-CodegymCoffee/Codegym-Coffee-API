package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.dto.news.NewsDTO;
import com.example.codegym_coffee.model.News;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface INewsService{
    void addNews (NewsDTO newsDTO);
    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: find all news
     * @param pageable
     */

    Page<News> findAllNews(Pageable pageable);

    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: find by id of News
     * @param id
     */
    News findByIdNews(int id);
}
