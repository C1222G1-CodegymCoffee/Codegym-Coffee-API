package com.example.codegym_coffee.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
public class MenuController_getAllTypeProduct {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getTypeProduct_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/menu/type-product"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getTypeProduct_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/menu/type-product")  )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameType").value("Category 1"))
                .andExpect(jsonPath("[1].nameType").value("Category 2"))
                .andExpect(jsonPath("[2].nameType").value("Category 3"));
    }
}
