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

    /**
     * @author TruongNN
     * @return lấy ra tất cả đối tượng có trong bảng news sắp xếp từ ngày mới nhất
     * Date created: 28/06/2023
     */
    @Query(value = "SELECT * FROM news ORDER BY day_post DESC", nativeQuery = true)
    Page<News> findAllNews(Pageable pageable);


    /**
     * @author TruongNN
     * @param idNews
     * @return đối tượng có tên News được tìm thấy dựa theo idNews
     * Date created: 28/06/2023
     */
    @javax.transaction.Transactional
    @Query(value = "select * from news where id_news=:id_news", nativeQuery = true)
    News findByIdNews(@Param("id_news") int idNews);
}
