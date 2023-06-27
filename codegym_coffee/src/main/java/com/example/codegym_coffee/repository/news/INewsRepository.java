package com.example.codegym_coffee.repository.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News,Integer> {
}
