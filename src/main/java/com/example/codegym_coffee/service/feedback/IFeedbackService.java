package com.example.codegym_coffee.service.feedback;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IFeedbackService {

    Page<Feedback> findAllFeedback(Pageable pageable);
    Feedback getFeedbackById(Integer id);
    Page<Feedback> findFeedbackByCreatorOrContent(String searchTerm, Pageable pageable);

    Page<Feedback> searchByCreatorOrContentAndDayOfFeedback(String searchTerm, LocalDate dayOfFeedback, Pageable pageable);
    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: Create feedback
     *
     * @param feedbackDTO
     */
    void createFeedback (FeedbackDTO feedbackDTO);
}
