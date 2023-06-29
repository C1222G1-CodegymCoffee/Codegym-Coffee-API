package com.example.codegym_coffee.repository.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

public interface INewsRepository extends JpaRepository<News,Integer> {

    /**
     * create by : ThongDM ,
     * Date Create : 27/06/2023
     * Function : Add new 1 news to db
     *
     * @param title
     * @param content
     * @param dayPost
     * @param image
     * @Param id_employee
     * @return no return value
     */
    @Transactional
    @Modifying
    @Query(value = "insert into news (title,content,day_post,image, id_employee) values (:title,:content,:day_post,:image,:id_employee)",
            nativeQuery = true)
    void addNews(@Param("title") String title, @Param("content") String content, @Param("day_post") LocalDate dayPost, @Param("image") String image, @Param("id_employee") Integer idEmployee);
}
