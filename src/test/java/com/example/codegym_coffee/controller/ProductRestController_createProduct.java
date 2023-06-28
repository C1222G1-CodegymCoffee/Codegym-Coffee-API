package com.example.codegym_coffee.controller;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.model.ProductType;
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
public class ProductRestController_createProduct {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * test the validation of field nameProduct is ""
     * @author NghiaLD
     */
    @Test
    public void createProduct_name_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(4);
        productDTO.setCodeProduct("A21");
        productDTO.setNameProduct("");
        productDTO.setPrice(123);
        productDTO.setImage("abcd");

        ProductType productType = new ProductType();
        productType.setIdType(3);
        productType.setNameType("cà phê");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation of field codeProduct is ""
     * @author NghiaLD
     */
    @Test
    public void createProduct_codeProduct_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(4);
        productDTO.setCodeProduct("");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(123);
        productDTO.setImage("abcd");

        ProductType productType = new ProductType();
        productType.setIdType(3);
        productType.setNameType("cà phê");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProduct_name_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(4);
        productDTO.setCodeProduct("A21");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(123);
        productDTO.setImage("abcd");

        ProductType productType = new ProductType();
        productType.setIdType(3);
        productType.setNameType("cà phê");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProduct_name_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(4);
        productDTO.setCodeProduct("A21");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(123);
        productDTO.setImage("abcd");

        ProductType productType = new ProductType();
        productType.setIdType(3);
        productType.setNameType("cà phê");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProduct_name_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(4);
        productDTO.setCodeProduct("A21");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(123);
        productDTO.setImage("abcd");

        ProductType productType = new ProductType();
        productType.setIdType(3);
        productType.setNameType("cà phê");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
