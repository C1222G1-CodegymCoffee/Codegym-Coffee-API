package com.example.codegym_coffee.repository.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface INewsRepository extends JpaRepository<News,Integer> {

    @Query(value = "SELECT * FROM news ORDER BY day_post DESC", nativeQuery = true)
    Page<News> findAllNews(Pageable pageable);
}
