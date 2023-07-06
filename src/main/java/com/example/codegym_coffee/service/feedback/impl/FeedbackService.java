package com.example.codegym_coffee.service.feedback.impl;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.repository.feedback.IFeedbackRepository;
import com.example.codegym_coffee.service.feedback.IFeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;


    @Override
    public Page<Feedback> findAllFeedback(Pageable pageable) {
        return feedbackRepository.findAllFeedback(pageable);
    }

    @Override
    public Page<Feedback> searchByCreatorOrContentAndDayOfFeedback(String searchTerm, LocalDate dayOfFeedback, Pageable pageable) {
        return feedbackRepository.findByCreatorOrContentAndDayOfFeedback(searchTerm, dayOfFeedback, pageable);
    }

    @Override
    public Feedback getFeedbackById(Integer id) {
        return feedbackRepository.findFeedbackById(id);
    }

    @Override
    public Page<Feedback> findFeedbackByCreatorOrContent(String searchTerm, Pageable pageable) {
        return feedbackRepository.findFeedbackByCreatorOrContent(searchTerm, pageable);
    }

//    public static String deAccent(String str) {
//        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//        return pattern.matcher(nfdNormalizedString).replaceAll("");
//    }
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
        feedbackRepository.createFeedback(
                feedback.getCodeFeedback(),
                feedback.getContent(),
                feedback.getCreator(),
                feedback.getEmail(),
                feedback.getImage(),
                feedback.getDayOfFeedback()
        );
    }
}
