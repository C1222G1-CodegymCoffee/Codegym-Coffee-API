package com.example.codegym_coffee.repository.feedback;

import com.example.codegym_coffee.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

    /**
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @param pageable (10)
     * @return findAllFeedback
     *  @Usage_method findAllFeedback to show list feedback
     */
    @Query(value = "SELECT id_feedback, code_feedback, day_of_feedback, email, creator, content FROM feedback", nativeQuery = true)
    Page<Feedback> findAllFeedback(Pageable pageable);

    @Query(value = "SELECT id_feedback, code_feedback, day_of_feedback, email, creator, content FROM feedback WHERE day_of_feedback like dayOfFeedback", nativeQuery = true)
    Page<Feedback> findByDayOfFeedback(@Param("dayOfFeedback") LocalDate dayOfFeedback, Pageable pageable);

}
