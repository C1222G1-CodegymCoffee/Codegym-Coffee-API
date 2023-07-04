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
public class HomePageRestController_getListProduct {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTopProduct_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/homepage/topProduct")  )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getTopProduct_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/homepage/topProduct/")  )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameProduct").value("Cafe 8"))
                .andExpect(jsonPath("[0].price").value(10000))
                .andExpect(jsonPath("[0].ingredient").value("Cafe 8 good"))
                .andExpect(jsonPath("[1].nameProduct").value("Cafe 4"))
                .andExpect(jsonPath("[1].price").value(10000))
                .andExpect(jsonPath("[1].ingredient").value("Cafe 4 good"))
                .andExpect(jsonPath("[2].nameProduct").value("Cafe 1"))
                .andExpect(jsonPath("[2].price").value(10000))
                .andExpect(jsonPath("[2].ingredient").value("Cafe 1 good"))
                .andExpect(jsonPath("[3].nameProduct").value("Cafe 3"))
                .andExpect(jsonPath("[3].price").value(10000))
                .andExpect(jsonPath("[3].ingredient").value("Cafe 3 good"))
                .andExpect(jsonPath("[4].nameProduct").value("Cafe 7"))
                .andExpect(jsonPath("[4].price").value(10000))
                .andExpect(jsonPath("[4].ingredient").value("Cafe 7 good"));

    }
    @Test
    public void getNewProduct_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/homepage/newProduct"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getNewProduct_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/homepage/newProduct")  )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameProduct").value("Cafe 8"))
                .andExpect(jsonPath("[0].price").value(10000))
                .andExpect(jsonPath("[0].ingredient").value("Cafe 8 good"))
                .andExpect(jsonPath("[1].nameProduct").value("Cafe 7"))
                .andExpect(jsonPath("[1].price").value(10000))
                .andExpect(jsonPath("[1].ingredient").value("Cafe 7 good"))
                .andExpect(jsonPath("[2].nameProduct").value("Cafe 6"))
                .andExpect(jsonPath("[2].price").value(10000))
                .andExpect(jsonPath("[2].ingredient").value("Cafe 6 good "))
                .andExpect(jsonPath("[3].nameProduct").value("Cafe 5"))
                .andExpect(jsonPath("[3].price").value(10000))
                .andExpect(jsonPath("[3].ingredient").value("Cafe 5 good"))
                .andExpect(jsonPath("[4].nameProduct").value("Cafe 4"))
                .andExpect(jsonPath("[4].price").value(10000))
                .andExpect(jsonPath("[4].ingredient").value("Cafe 4 good"));

    }
}
