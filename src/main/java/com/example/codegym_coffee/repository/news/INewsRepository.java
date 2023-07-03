package com.example.codegym_coffee.repository.news;

import com.example.codegym_coffee.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface INewsRepository extends JpaRepository<News,Integer> {

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
    @Transactional
    @Query(value = "select * from news where id_news=:id_news", nativeQuery = true)
    News findByIdNews(@Param("id_news") int idNews);
}
