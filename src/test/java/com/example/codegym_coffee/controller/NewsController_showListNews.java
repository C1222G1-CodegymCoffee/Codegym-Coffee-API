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
                .andExpect(jsonPath("content[0].idNews").value(2))
                .andExpect(jsonPath("content[0].title").value("Tuyển nhân viên"))
                .andExpect(jsonPath("content[0].content").value("Tuyển nhân viên pha chế ca tối"))
                .andExpect(jsonPath("content[0].dayPost").value("2023-06-29"))
                .andExpect(jsonPath("content[0].image").value("ccc"))
                .andExpect(jsonPath("content[0].employee.idEmployee").value(1))

                .andExpect(jsonPath("content[1].idNews").value(4))
                .andExpect(jsonPath("content[1].title").value("Ưu đãi free ship"))
                .andExpect(jsonPath("content[1].content").value("miễn phí giao hàng trong bán kính 2km"))
                .andExpect(jsonPath("content[1].dayPost").value("2023-06-29"))
                .andExpect(jsonPath("content[1].image").value("aaa"))
                .andExpect(jsonPath("content[1].employee.idEmployee").value(1));
    }
}
