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
public class SaleController_findAllTableCoffee {

    @Autowired
    private MockMvc mockMvc;

    /**
     * @Author: KhaiNLV
     * Function to check the case of a list with size 0
     * @Throws Exception if an error occurs during the test execution
     */
    @Test
    public void findAllTableCoffee_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * @Author: KhaiNLV
     * Function to check the case of a list with size greater than 0
     * @Throws Success
     */
    @Test
    public void findAllTableCoffee_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].idTable").value(1))
                .andExpect(jsonPath("[0].nameTable").value("T1-01"))
                .andExpect(jsonPath("[0].status").value(1))
                .andExpect(jsonPath("[1].idTable").value(2))
                .andExpect(jsonPath("[1].nameTable").value("T1-02"))
                .andExpect(jsonPath("[1].status").value(1))
                .andExpect(jsonPath("[2].idTable").value(3))
                .andExpect(jsonPath("[2].nameTable").value("T1-03"))
                .andExpect(jsonPath("[2].status").value(1))
                .andExpect(jsonPath("[3].idTable").value(4))
                .andExpect(jsonPath("[3].nameTable").value("T1-04"))
                .andExpect(jsonPath("[3].status").value(1))
                .andExpect(jsonPath("[4].idTable").value(5))
                .andExpect(jsonPath("[4].nameTable").value("T1-05"))
                .andExpect(jsonPath("[4].status").value(1))
                .andExpect(jsonPath("[5].idTable").value(6))
                .andExpect(jsonPath("[5].nameTable").value("T1-06"))
                .andExpect(jsonPath("[5].status").value(1))
                .andExpect(jsonPath("[6].idTable").value(7))
                .andExpect(jsonPath("[6].nameTable").value("T1-07"))
                .andExpect(jsonPath("[6].status").value(1))
                .andExpect(jsonPath("[7].idTable").value(8))
                .andExpect(jsonPath("[7].nameTable").value("T1-08"))
                .andExpect(jsonPath("[7].status").value(1));
    }

}
