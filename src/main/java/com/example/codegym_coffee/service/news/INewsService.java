package com.example.codegym_coffee.service.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewsService{

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
