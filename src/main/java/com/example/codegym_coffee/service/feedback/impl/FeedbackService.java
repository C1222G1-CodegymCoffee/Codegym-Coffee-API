package com.example.codegym_coffee.service.feedback.impl;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.repository.feedback.IFeedbackRepository;
import com.example.codegym_coffee.service.feedback.IFeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private IFeedbackRepository ifeedbackRepository;


    /**
     * @author: TruongNN
     * Date created: 28/06/2023
     * function: Create feedback
     *
     */
    @Override
    public void createFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackDTO, feedback);
        ifeedbackRepository.createFeedback(
                feedback.getCodeFeedback(),
                feedback.getContent(),
                feedback.getCreator(),
                feedback.getEmail(),
                feedback.getImage(),
                feedback.getDayOfFeedback()
        );
    }

    @Override
    public List<Feedback> findAllFeedback() {
        return ifeedbackRepository.findAll();
    }
}
