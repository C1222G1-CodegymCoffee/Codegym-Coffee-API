package com.example.codegym_coffee.service.feedback;

import com.example.codegym_coffee.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface IFeedbackService {
    Page<Feedback> findAllFeedback( Pageable pageable);
    Page<Feedback> findFeedbackByDay(LocalDate dayOfFeedback, Pageable pageable);
    Feedback getFeedbackById(Integer id);
    Page<Feedback> findFeedbackByCreatorOrContent(String searchTerm, Pageable pageable);

}
