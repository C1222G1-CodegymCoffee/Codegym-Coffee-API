package com.example.codegym_coffee.controller.feedback;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.example.codegym_coffee.model.Feedback;
import com.example.codegym_coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class FeedbackController {


    @Autowired
    private IFeedbackService iFeedbackService;

    @GetMapping("/admin/list-feedback")
    public ResponseEntity<List<Feedback>> showAll() {
        List<Feedback> feedbackList = iFeedbackService.findAllFeedback();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    /**
     * Created by: TruongNN
     * Date created: 28/06/2023
     * Function: add data feedback  into Database
     * @param feedbackDTO
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/public/create-feedback")
    public ResponseEntity<FeedbackDTO> createFeedback(@Valid @RequestBody FeedbackDTO feedbackDTO,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);
        }
        iFeedbackService.createFeedback(feedbackDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
