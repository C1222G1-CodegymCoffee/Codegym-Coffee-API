package com.example.codegym_coffee.controller;

import com.example.codegym_coffee.model.Bill;
import com.example.codegym_coffee.model.TableCoffee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SaleController_updatePaymentStatusToZero {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Author: KhaiNLV
     * Function to check the case of a list with size 0
     * @Throws Exception if an error occurs during the test execution
     */
    @Test
    public void updatePaymentStatusToZero_19() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/sale/update/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePaymentStatusToZero_20() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/sale/update/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updatePaymentStatusToZero_21() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/sale/update/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @Author: KhaiNLV
     * Function to check the case of a list with size greater than 0
     * @Throws Success
     */
    @Test
    public void updatePaymentStatusToZero_24() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/sale/update/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
