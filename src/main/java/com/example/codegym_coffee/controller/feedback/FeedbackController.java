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
@RequestMapping("/api")
@CrossOrigin("*")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * @param pageable (10)
     * @return ResponseEntity<>(listFeedback,HttpStatus.OK)
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @Usage_method The method used to show list feedback
     */
    @GetMapping("/admin/list-feedback")
    public ResponseEntity<Page<Feedback>> listFeedback(@PageableDefault(size = 10) Pageable pageable,
                                                       @RequestParam(value = "page", defaultValue = "0") int page) {
        pageable = PageRequest.of(page, 10);
        Page<Feedback> pageFeedback = feedbackService.findAllFeedback(pageable);

        if (pageFeedback.isEmpty()) {
            return new ResponseEntity<>(pageFeedback, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pageFeedback, HttpStatus.OK);
    }


    /**
     * @param dayOfFeedback
     * @return ResponseEntity<>(listFeedbackDay,HttpStatus.OK)
     * @Author TrinhCHT
     * @Date_create: 27/06/2023
     * @Usage_method The method used to search feedback by dayOfFeedback
     */
    @GetMapping("/admin/list-feedback/search")
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
    @GetMapping("admin/feedback/detail/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") Integer id) {
        Feedback feedback = feedbackService.getFeedbackById(id);
        if (feedback == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }
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

