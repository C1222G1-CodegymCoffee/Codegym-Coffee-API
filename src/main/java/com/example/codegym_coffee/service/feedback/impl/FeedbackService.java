package com.example.codegym_coffee.service.feedback.impl;

import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.repository.feedback.IFeedbackRepository;
import com.example.codegym_coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public Page<Feedback> findAllFeedback(Pageable pageable) {
        return feedbackRepository.findAllFeedback(pageable);
    }

    @Override
    public Page<Feedback> findFeedbackByDay(LocalDate dayOfFeedback, Pageable pageable) {
        return feedbackRepository.findByDayOfFeedback(dayOfFeedback, pageable);
    }

}
