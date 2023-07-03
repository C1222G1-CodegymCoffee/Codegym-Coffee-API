package com.example.codegym_coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_getProductById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * @Author: NghiaLD
     * This is a method used to check for getting id of product when the id = null
     * @Throws Exception
     */

    @Test
    public void getProductById_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/product/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: NghiaLD
     * This is a method used to check for getting id of product when the id = ''
     * @Throws Exception
     */
    @Test
    public void getProductById_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/product/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: NghiaLD
     * This is a method used to check for getting id of product when the id is not in Database
     * @Throws Exception
     */
    @Test
    public void getProductById_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/product/400"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: NghiaLD
     * This is a method used to check for getting id of product when the id has in Database
     * @Throws Exception
     */
    @Test
    public void getProductById_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/product/10"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
