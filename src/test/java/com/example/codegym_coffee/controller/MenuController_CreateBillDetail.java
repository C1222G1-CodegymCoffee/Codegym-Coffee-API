package com.example.codegym_coffee.controller;

import com.example.codegym_coffee.model.BillDetail;
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
public class MenuController_CreateBillDetail {

    @Autowired
    private MockMvc mockMvc ;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createBillDetail_quantity_13() throws Exception {
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantityOfProduct(0);
        billDetail.setPriceOfProduct(10000);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/menu/add-to-bill")
                        .content(this.objectMapper.writeValueAsString(billDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createBillDetail_price_13() throws Exception {
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantityOfProduct(1);
        billDetail.setPriceOfProduct(0);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/menu/add-to-bill")
                        .content(this.objectMapper.writeValueAsString(billDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void  createBillDetail_quantity_15() throws Exception {
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantityOfProduct(-1);
        billDetail.setPriceOfProduct(1000);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/menu/add-to-bill")
                        .content(this.objectMapper.writeValueAsString(billDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createBillDetail_price_15() throws Exception {
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantityOfProduct(1);
        billDetail.setPriceOfProduct(-1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/menu/add-to-bill")
                        .content(this.objectMapper.writeValueAsString(billDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_18() throws Exception {
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantityOfProduct(1);
        billDetail.setPriceOfProduct(10000);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/menu/add-to-bill")
                        .content(this.objectMapper.writeValueAsString(billDetail))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
