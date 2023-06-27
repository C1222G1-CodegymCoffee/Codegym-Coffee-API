package com.example.codegym_coffee.repository.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INewsRepository extends JpaRepository<News,Integer> {
    @Query(value = "SELECT * FROM news ", nativeQuery = true)
    List<News> findAlNews();
}
