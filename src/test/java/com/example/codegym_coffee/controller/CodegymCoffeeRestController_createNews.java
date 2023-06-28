package com.example.codegym_coffee.controller;

import com.example.codegym_coffee.dto.news.NewsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CodegymCoffeeRestController_createNews {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void createNews_title_14() throws Exception {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("");
        newsDTO.setContent("1");
        Date dayPost = new Date(); // Tạo đối tượng Date với giá trị ngày mong muốn
        newsDTO.setDayPost(dayPost);
        newsDTO.setImage("1");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/news/createNews")
                .content(this.objectMapper.writeValueAsString(newsDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createNews_content_14() throws Exception {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("1");
        newsDTO.setContent("");
        Date dayPost = new Date(); // Tạo đối tượng Date với giá trị ngày mong muốn
        newsDTO.setDayPost(dayPost);
        newsDTO.setImage("1");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_image_14() throws Exception {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("1");
        newsDTO.setContent("1");
        Date dayPost = new Date(); // Tạo đối tượng Date với giá trị ngày mong muốn
        newsDTO.setDayPost(dayPost);
        newsDTO.setImage("");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_title_15() throws Exception {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("@@");
        newsDTO.setContent("1");
        Date dayPost = new Date(); // Tạo đối tượng Date với giá trị ngày mong muốn
        newsDTO.setDayPost(dayPost);
        newsDTO.setImage("1");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void createNews_18() throws Exception {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("1");
        newsDTO.setContent("1");
        Date dayPost = new Date(); // Tạo đối tượng Date với giá trị ngày mong muốn
        newsDTO.setDayPost(dayPost);
        newsDTO.setImage("1");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
