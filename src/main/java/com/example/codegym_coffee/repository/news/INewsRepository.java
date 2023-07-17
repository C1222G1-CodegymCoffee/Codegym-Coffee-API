package com.example.codegym_coffee.repository.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;



public interface INewsRepository extends JpaRepository<News,Integer> {

    
    @Transactional
    @Modifying
    @Query(value = "insert into news (title,content,day_post,image, id_employee) values (:title,:content,:day_post,:image,:id_employee)",
            nativeQuery = true)
    void addNews(@Param("title") String title, @Param("content") String content, @Param("day_post") LocalDate dayPost, @Param("image") String image, @Param("id_employee") Integer idEmployee);

    @Query(value = "SELECT * FROM news ORDER BY day_post DESC", nativeQuery = true)
    Page<News> findAllNews(Pageable pageable);


  
    @javax.transaction.Transactional
    @Query(value = "select * from news where id_news=:id_news", nativeQuery = true)
    News findByIdNews(@Param("id_news") int idNews);
}
