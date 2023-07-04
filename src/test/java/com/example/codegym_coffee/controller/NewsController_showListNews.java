package com.example.codegym_coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class NewsController_showListNews {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to check the return list is 0
     * @author TruongNN
     * time 15h 28/06/2023
     */
    @Test
    public void showListNews_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/list-news"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is used to check the returned list has size > 0
     * @author TruongNN
     * time 15h 28/06/2023
     */

    @Test
    public void showListNews_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/list-news"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idNews").value(14))
                .andExpect(jsonPath("content[0].title").value("Ưu đãi khai trương"))
                .andExpect(jsonPath("content[0].content").value("Giảm 10% cho tất cả hóa đơn"))
                .andExpect(jsonPath("content[0].dayPost").value("2023-06-28"))
                .andExpect(jsonPath("content[0].image").value("abc"))

                .andExpect(jsonPath("content[3].idNews").value(17))
                .andExpect(jsonPath("content[3].title").value("Ưu đãi khai trương"))
                .andExpect(jsonPath("content[3].content").value("Giảm 50% cho hóa đơn từ 1tr"))
                .andExpect(jsonPath("content[3].dayPost").value("2023-06-28"))
                .andExpect(jsonPath("content[3].image").value("ccc"));
    }
}
