package com.example.codegym_coffee.controller;

import com.example.codegym_coffee.dto.feedback.FeedbackDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackController_createFeedback {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field code feedback more specific is null
     *
     * @author TruongNN
     * @time 14H 28/06/2023
     **/

    @Test
    public void createFeedback_codeFeedback_13() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator(null);
        feedbackDTO.setEmail("truong@gmail.com");
        feedbackDTO.setContent("do uong dep mat");
        feedbackDTO.setImage("abc.npg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field email more specific is null
     *
     * @author TruongNN
     * @time 14H 28/06/2023
     **/
    @Test
    public void createFeedback_email_13() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail(null);
        feedbackDTO.setContent("do uong dep mat");
        feedbackDTO.setImage("abc.npg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field content more specific is null
     *
     * @author TruongNN
     * @time 14H 28/06/2023
     **/
    @Test
    public void createFeedback_content_13() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent(null);
        feedbackDTO.setImage("abc.npg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field image more specific is null
     *
     * @author TruongNN
     * @time 14H 28/06/2023
     **/
    @Test
    public void createFeedback_image_13() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to check the validity of specific field creator instead of empty
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */
    @Test
    public void createFeedback_creator_14() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.npg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to check the validity of specific field email instead of empty
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */
    @Test
    public void createFeedback_email_14() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.npg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to check the validity of specific field content instead of empty
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */
    @Test
    public void createFeedback_content_14() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("");
        feedbackDTO.setImage("abc.npg");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to check the validity of specific field image instead of empty
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */
    @Test
    public void createFeedback_image_14() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of the creator field due to incorrect formatting
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_creator_15() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong @###");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of the email field due to incorrect formatting
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */
    @Test
    public void createFeedback_email_15() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of the image field due to incorrect formatting
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_image_15() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.abc");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of a specific field creator because its length is too short
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_creator_16() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to check the validity of a specific field creator because its length is too long
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_creator_17() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong " +
                "Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong " +
                "Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of a specific field email because its length is too short
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_email_16() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngo@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to check the validity of a specific field email because its length is too long
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_email_17() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong ");
        feedbackDTO.setEmail("ngongoctruongngongoctruongngongoctruongngongoctruongngongoctruong" +
                "ngongoctruongngongoctruongngongoctruongngongoctruongngongoctruongngongoctruong" +
                "ngongoctruongngongoctruongngongoctruongngongoctruongngongoctruongngongoctruong" +
                "ngongoctruongngongoctruongngongoctruongngongoctruongngongoctruongngongoctruong@gmail.com");
        feedbackDTO.setContent("do uong qua la tuyet voi");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of a specific field content because its length is too short
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_content_16() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("abc");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to check the validity of a specific field content because its length is too long
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_content_17() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu" +
                "bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu" +
                "bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu" +
                "bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu" +
                "bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu bạn quá là tuyệt vời, mãi mãi yêu bạn, lớp diu");
        feedbackDTO.setImage("abc.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to check the validity of all fields
     *
     * @author TruongNN
     * @time 14h 28/06/2023
     */

    @Test
    public void createFeedback_18() throws Exception {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setCreator("Ngo Ngoc Truong");
        feedbackDTO.setEmail("ngongoctruong@gmail.com");
        feedbackDTO.setContent("Đồ uống của quán quá là ngon, tuyệt vời");
        feedbackDTO.setImage("hinh.png");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/public/create-feedback")
                        .content(this.objectMapper.writeValueAsString(feedbackDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
