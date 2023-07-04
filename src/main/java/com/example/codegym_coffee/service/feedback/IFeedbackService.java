package com.example.codegym_coffee.service.feedback;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;

import java.util.List;

public interface IFeedbackService {

    void createFeedback (FeedbackDTO feedbackDTO);

    List<Feedback> findAllFeedback();

}
