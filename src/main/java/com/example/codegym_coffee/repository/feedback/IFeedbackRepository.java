package com.example.codegym_coffee.repository.feedback;

import com.example.codegym_coffee.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

    /**
     * @author TruongNN
     * Funcition: thêm mới feedback vào database
     * Date created: 28/06/2023
     */
    @Modifying
    @Transactional
    @Query(value = "insert into feedback(code_feedback , content, creator , email , image , day_of_feedback)" +
            " values (:code_feedback,:content, :creator,:email,:image , :day_of_feedback)", nativeQuery = true)
    void createFeedback(@Param("code_feedback") String code_feedback,
                        @Param("content") String content,
                        @Param("creator") String creator,
                        @Param("email") String email,
                        @Param("image") String image,
                        @Param("day_of_feedback") LocalDate day_of_feedback);
}
