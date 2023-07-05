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
     * @param pageable (10)
     * @return findAllFeedback
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @Usage_method findAllFeedback to show list feedback
     */
    @Query(value = "SELECT id_feedback, code_feedback, day_of_feedback, email, creator, content , image\n" +
            "FROM feedback ORDER BY day_of_feedback DESC", nativeQuery = true)
    Page<Feedback> findAllFeedback(Pageable pageable);

    @Query(value = "SELECT id_feedback, code_feedback, day_of_feedback, email, creator, content , image FROM feedback WHERE day_of_feedback = :dayOfFeedback", nativeQuery = true)
    Page<Feedback> findByDayOfFeedback(@Param("dayOfFeedback") LocalDate dayOfFeedback, Pageable pageable);

    @Query(value = "SELECT id_feedback, code_feedback, day_of_feedback, email, creator, content , image\n" +
            "FROM feedback WHERE id_feedback= :id", nativeQuery = true)
    Feedback findFeedbackById(@Param("id") Integer id);

//    @Query("SELECT f FROM Feedback f WHERE f.creator LIKE %:searchTerm% OR f.content LIKE %:searchTerm% ORDER BY f.dayOfFeedback DESC")
    @Query("SELECT f FROM Feedback f WHERE f.creator LIKE CONCAT('%', :searchTerm, '%') OR f.content LIKE CONCAT('%', :searchTerm, '%') ORDER BY f.dayOfFeedback DESC")
    Page<Feedback> findFeedbackByCreatorOrContent(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT f FROM Feedback f WHERE (f.creator LIKE CONCAT('%', :searchTerm, '%') OR f.content LIKE CONCAT('%', :searchTerm, '%')) AND f.dayOfFeedback = :dayOfFeedback ORDER BY f.dayOfFeedback DESC")
    Page<Feedback> findByCreatorOrContentAndDayOfFeedback(@Param("searchTerm") String searchTerm, LocalDate dayOfFeedback, Pageable pageable);

}
