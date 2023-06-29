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
public class BillRestController_search_day {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test case find bill day with null parameter
     *
     * @throws Exception
     */
    @Test
    public void search_code_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/bill/code/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case finds bill day with empty parameter
     *
     * @throws Exception
     */
    @Test
    public void search_code_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/bill/code?="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case finds bill day whose parameter does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void search_code_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/bill/code?=non-existing-code"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case find bill day whose parameter exists in database
     *
     * @throws Exception
     */
    @Test
    public void search_code_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/bill/day/2023-02-15"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idBill").value(1))
                .andExpect(jsonPath("content[0].codeBill").value("HD01"))
                .andExpect(jsonPath("content[0].dayOfBill").value("2023-02-15"))
                .andExpect(jsonPath("content[0].employee.nameEmployee").value("Trịnh Công Sơn"))
                .andExpect(jsonPath("content[0].feedback.email").value("truong@gmail.com"))
                .andExpect(jsonPath("content[0].tableCoffee.nameTable").value("Vip"));
    }

}
