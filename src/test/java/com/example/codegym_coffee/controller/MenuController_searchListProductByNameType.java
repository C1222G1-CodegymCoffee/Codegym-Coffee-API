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
public class MenuController_searchListProductByNameType {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void searchProductByNameType_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/menu/product-by-type?type=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchProductByNameType_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/menu/product-by-type?type="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchProductByNameType_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/menu/product-by-type?type=gfgdfgdfgd"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void searchProductByNameType_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/menu/product-by-type?type=Category 1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].nameProduct").value("Cafe 1"))
                .andExpect(jsonPath("[0].price").value(10000))
                .andExpect(jsonPath("[0].image").value("img1.png"))
                .andExpect(jsonPath("[1].nameProduct").value("Cafe 2"))
                .andExpect(jsonPath("[1].price").value(10000))
                .andExpect(jsonPath("[1].image").value("img2.png"))
                .andExpect(jsonPath("[2].nameProduct").value("Cafe 3"))
                .andExpect(jsonPath("[2].price").value(10000))
                .andExpect(jsonPath("[2].image").value("img3.png"))
                .andExpect(jsonPath("[3].nameProduct").value("Cafe 4"))
                .andExpect(jsonPath("[3].price").value(10000))
                .andExpect(jsonPath("[3].image").value("img4.png"))
                .andExpect(jsonPath("[4].nameProduct").value("Cafe 5"))
                .andExpect(jsonPath("[4].price").value(10000))
                .andExpect(jsonPath("[4].image").value("img5.png"));
    }
}
