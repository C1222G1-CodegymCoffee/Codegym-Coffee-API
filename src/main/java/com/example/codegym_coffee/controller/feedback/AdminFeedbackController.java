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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/admin/feedbacks")
@CrossOrigin("*")
public class AdminFeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * @param pageable (10)
     * @return ResponseEntity<>(listFeedback,HttpStatus.OK)
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @Usage_method The method used to show list feedback
     */
    @GetMapping()
    public ResponseEntity<Page<Feedback>> listFeedback(@PageableDefault(size = 10) Pageable pageable,
                                                       @RequestParam(value = "page", defaultValue = "0") int page) {
        pageable = PageRequest.of(page, 10);
        Page<Feedback> pageFeedback = feedbackService.findAllFeedback(pageable);

        return new ResponseEntity<>(pageFeedback, HttpStatus.OK);
    }


    /**
     * @param dayOfFeedback
     * @return ResponseEntity<>(listFeedbackDay,HttpStatus.OK)
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @Usage_method The method used to search feedback by dayOfFeedback
     */
    @GetMapping("/search")
    public ResponseEntity<Page<Feedback>> searchFeedback(
            @RequestParam(name = "searchTerm", defaultValue = "") String searchTerm,
            @RequestParam(name = "dayOfFeedback", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dayOfFeedback,
            Pageable pageable) {

        Page<Feedback> feedbacks;

        if (dayOfFeedback != null) {
            feedbacks = feedbackService.searchByCreatorOrContentAndDayOfFeedback(searchTerm, dayOfFeedback, pageable);
        }  else  {
            feedbacks = feedbackService.findFeedbackByCreatorOrContent(searchTerm, pageable);
        }

        return ResponseEntity.ok(feedbacks);
    }


    /**
     * @param id
     * @return ResponseEntity<>(feedback, HttpStatus.OK)
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @Usage_method The method used to show detail feedback
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") Integer id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

}

