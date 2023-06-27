package com.example.codegym_coffee.controller.feedback;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/admin/feedback")
@CrossOrigin("*")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @param pageable (10)
     * @return ResponseEntity<>(listFeedback,HttpStatus.OK)
     *  @Usage_method The method used to show list feedback
     */
    @GetMapping("/")
    public ResponseEntity<Page<Feedback>> list(@PageableDefault(size = 10) Pageable pageable, @RequestParam(value = "page", defaultValue = "0") int page) {
        pageable = PageRequest.of(page, 10);
        Page<Feedback> listFeedback = feedbackService.findAllFeedback(pageable);
        if (listFeedback.isEmpty()) {
            return new ResponseEntity<>(listFeedback, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listFeedback, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Feedback>> getFeedbackByDay(@RequestParam("dayOfFeedback") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dayOfFeedback,
                                                           Pageable pageable) {
        Page<Feedback> listFeedbackDay = feedbackService.findFeedbackByDay(dayOfFeedback, pageable);
        if (listFeedbackDay.isEmpty()) {
            return new ResponseEntity<>(listFeedbackDay, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listFeedbackDay, HttpStatus.OK);
    }
}

