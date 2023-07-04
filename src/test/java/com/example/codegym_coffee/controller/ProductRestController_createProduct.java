package com.example.codegym_coffee.controller;

import com.example.codegym_coffee.dto.product.ProductDTO;
import com.example.codegym_coffee.dto.product.ProductTypeDTO;
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
     * test the validation for create product of field nameProduct is null
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_name_13() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct(null);
        productDTO.setIngredient("đường,muối");
        productDTO.setPrice(12.3);
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
     * test the validation for create product of field price is null
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_price_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setIngredient("đường,muối");
        productDTO.setPrice(null);
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
    public void createProduct_ingredient_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setIngredient(null);
        productDTO.setPrice(12.3);
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
     * test the validation for create product of field image is null
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_image_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setIngredient("đường,muối");
        productDTO.setPrice(12.3);
        productDTO.setImage(null);

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
     * test the validation for create product of field productType is null
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_productType_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setIngredient("đường,muối");
        productDTO.setPrice(12.3);
        productDTO.setImage("abcd");

        ProductType productType = new ProductType();
        productType.setIdType(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for create product of field nameProduct is ""
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_nameProduct_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("");
        productDTO.setIngredient("đường,muối");
        productDTO.setPrice(12.3);
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
    public void createProduct_price_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("Trà Nhài");
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
    public void createProduct_productType_14() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("abcd");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of nameProduct have special charactor or number;
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_name_15() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong,muoi");
        productDTO.setNameProduct("Nghĩa123");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of ingredient have special charactor or number;
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_ingredient_15() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong,dao,muoi");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * test the validation of nameProduct with min length
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_nameProduct_16() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong");
        productDTO.setNameProduct("T");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation of ingredient with min length
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_ingredient_16() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("đa");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * test the validation of nameProduct with max length
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_nameProduct_17() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("đường,muối");
        productDTO.setNameProduct("Trà Nhàiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * test the validation of ingredient with max length
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_ingredient_17() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duon");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test all items are correct
     *
     * @author NghiaLD
     */
    @Test
    public void createProduct_name_18() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong");
        productDTO.setNameProduct("Trà Nhài abc");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}

