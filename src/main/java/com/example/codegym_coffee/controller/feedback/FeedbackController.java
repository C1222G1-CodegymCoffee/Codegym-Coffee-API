package com.example.codegym_coffee.controller.feedback;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class FeedbackController {


    @Autowired
    private IFeedbackService iFeedbackService;

    @GetMapping("/list")
    public ResponseEntity<List<Feedback>> showAll() {

        List<Feedback> feedbackList = iFeedbackService.findAllFeedback();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/public/create")
    public ResponseEntity<?> createFeedback(@Valid @RequestBody FeedbackDTO feedbackDTO) {
        iFeedbackService.createFeedback(feedbackDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
