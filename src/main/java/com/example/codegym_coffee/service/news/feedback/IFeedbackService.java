package com.example.codegym_coffee.service.news.feedback;

import com.example.codegym_coffee.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IFeedbackService {
//    Page<Feedback> findAllFeedback( List<Feedback> pageable);

    Page<Feedback> findAllFeedback(Pageable pageable);
    Feedback getFeedbackById(Integer id);
    Page<Feedback> findFeedbackByCreatorOrContent(String searchTerm, Pageable pageable);

    Page<Feedback> searchByCreatorOrContentAndDayOfFeedback(String searchTerm, LocalDate dayOfFeedback, Pageable pageable);

}
