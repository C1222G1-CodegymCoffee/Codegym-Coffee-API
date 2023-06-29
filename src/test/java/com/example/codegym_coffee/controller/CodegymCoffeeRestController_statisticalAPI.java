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
public class CodegymCoffeeRestController_statisticalAPI {
    @Autowired
    private MockMvc mockMvc;

    /**
     * ngày nhập null
     * @throws Exception
     */
    @Test
    public void getStatistic_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/statistic/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * ngày nhập rỗng
     * @throws Exception
     */
    @Test
    public void getStatistic_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/statistic/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * ngày nhập ngày không tồn tại
     * @throws Exception
     */
    @Test
    public void getStatistic_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/statistic/2025-07-08"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//
//    /**
//     * ngày đầu lớn hơn ngày kết thúc
//     * @throws Exception
//     */
//    @Test
//    public void getStatistic_99() throws Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.get(
//                                "/statistic?dateAfter=2022-06-25&dateBefore=2023-06-08"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }


    /**
     * ngày nhập ngày tồn tại
     * @throws Exception
     */
    @Test
    public void getStatistic_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/statistic?dateAfter=202206-05&dateBefore=2023-06-08"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
