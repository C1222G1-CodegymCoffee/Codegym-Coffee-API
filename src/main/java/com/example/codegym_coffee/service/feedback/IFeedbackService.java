package com.example.codegym_coffee.service.feedback;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;

import java.util.List;

public interface IFeedbackService {


    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: Create feedback
     *
     * @param feedbackDTO
     */
    void createFeedback (FeedbackDTO feedbackDTO);

    List<Feedback> findAllFeedback();

}
