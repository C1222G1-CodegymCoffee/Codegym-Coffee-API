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
public class BillRestController_getAllList {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This method is used to check the returned list is of size 0
     * ThanhNV
     * @throws Exception
     */
    @Test
    public void getListBill_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/bill"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This method is used to check the returned list is of size > 0
     *ThanhNV
     * @throws Exception
     */
    @Test
    public void getListBill_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/bill"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idBill").value(1))
                .andExpect(jsonPath("content[0].codeBill").value("HD01"))
                .andExpect(jsonPath("content[0].dayOfBill").value("2023-02-15"))
                .andExpect(jsonPath("content[0].employee.nameEmployee").value("Trịnh Công Sơn"))
                .andExpect(jsonPath("content[0].feedback.email").value("truong@gmail.com"))
                .andExpect(jsonPath("content[0].tableCoffee.nameTable").value("Vip"))
        ;
    }

     /**
     * This method is used to check the returned list is of location 2
     *
     * @throws Exception
     */
    @Test
    public void getListBill_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/bill"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[1].idBill").value(2))
                .andExpect(jsonPath("content[1].codeBill").value("HD02"))
                .andExpect(jsonPath("content[1].dayOfBill").value("2022-02-22"))
                .andExpect(jsonPath("content[1].employee.nameEmployee").value("Trịnh Công Sơn"))
                .andExpect(jsonPath("content[1].feedback.email").value("truong@gmail.com"))
                .andExpect(jsonPath("content[1].tableCoffee.nameTable").value("Vip"))
        ;
    }

/**
     * This method is used to check the returned list is of page 2
     *
     * @throws Exception
     */
    @Test
    public void getListBill_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/admin/bill?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].idBill").value(6))
                .andExpect(jsonPath("content[2].codeBill").value("HD08"))
                .andExpect(jsonPath("content[2].dayOfBill").value("2022-02-02"))
                .andExpect(jsonPath("content[4].employee.nameEmployee").value("Trịnh Công Sơn"))
                .andExpect(jsonPath("content[4].feedback.email").value("truong@gmail.com"))
                .andExpect(jsonPath("content[4].tableCoffee.nameTable").value("Vip"))
        ;
    }



}
