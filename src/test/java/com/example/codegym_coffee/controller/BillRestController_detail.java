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
public class BillRestController_detail {
    @Autowired
    private MockMvc mockMvc;

    /**
     * list null, search id (null)
     * ThanhNV
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api/admin/bill/detail/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * list hollow, search id ()
     *ThanhNV
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api/admin/bill/detail/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * list 999, search id (not in database)
     *
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api/admin/bill/detail/999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * list 1, search id (1)
     *
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api/admin/bill/detail/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idBill").value(1))
                .andExpect(jsonPath("codeBill").value("HD01"))
                .andExpect(jsonPath("dayOfBill").value("2023-02-15"))
                .andExpect(jsonPath("employee.nameEmployee").value("Trịnh Công Sơn"))
                .andExpect(jsonPath("feedback.email").value("truong@gmail.com"))
                .andExpect(jsonPath("tableCoffee.nameTable").value("Vip"))
                .andExpect(jsonPath("billDetail.quantityOfProduct").value(20))
                .andExpect(jsonPath("billDetail.priceOfProduct").value(25.0))
        ;
    }

}
