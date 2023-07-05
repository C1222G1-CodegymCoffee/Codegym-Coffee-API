package com.example.codegym_coffee.controller.feedback;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin("*")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * Created by: TruongNN
     * Date created: 28/06/2023
     * Function: add data feedback  into Database
     * @param feedbackDTO
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-feedback")
    public ResponseEntity<FeedbackDTO> createFeedback(@Valid @RequestBody FeedbackDTO feedbackDTO,
                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);
        }
        feedbackService.createFeedback(feedbackDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

