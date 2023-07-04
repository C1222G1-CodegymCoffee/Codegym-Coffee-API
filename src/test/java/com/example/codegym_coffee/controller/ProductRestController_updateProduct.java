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
public class ProductRestController_updateProduct {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * test the validation for update product of field nameProduct is null
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_name_19() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong");
        productDTO.setNameProduct(null);
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * test the validation for update product of field ingredient is null
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_ingredient_19() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient(null);
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field price is null
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_price_19() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(null);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field image is null
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_image_19() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage(null);
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field productType is null
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_productType_19() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field ingredient is ''
     *
     * @author NghiaLD
     */

    @Test
    public void updateProduct_ingredient_20() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field nameProduct is ''
     *
     * @author NghiaLD
     */

    @Test
    public void updateProduct_nameProduct_20() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("đường,muối");
        productDTO.setNameProduct("");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field price is ''
     *
     * @author NghiaLD
     */

    @Test
    public void updateProduct_price_20() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field image is ''
     *
     * @author NghiaLD
     */

    @Test
    public void updateProduct_image_20() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("đường, muối");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation for update product of field productType is ''
     *
     * @author NghiaLD
     */

    @Test
    public void updateProduct_productType_20() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("");
        productDTO.setNameProduct("Trà Hoa Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
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
    public void updateProduct_nameProduct_21() throws Exception {

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
                        .patch("/api/product/update/1")
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
    public void updateProduct_ingredient_21() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong,muoi12");
        productDTO.setNameProduct("Trà Táo");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * test the validation of nameProduct with min length
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_nameProduct_22() throws Exception {

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
                        .patch("/api/product/update/1")
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
    public void updateProduct_ingredient_22() throws Exception {

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
                        .patch("/api/product/update/1")
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
    public void updateProduct_nameProduct_23() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong,muoi");
        productDTO.setNameProduct("Trà dauuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * test the validation of ingredient with max length
     *
     * @author NghiaLD
     */
    @Test
    public void updateProduct_ingredient_23() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("duong,muoiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        productDTO.setNameProduct("Trà Vải");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
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
    public void createProduct_name_24() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIngredient("trà, hoa nhài");
        productDTO.setNameProduct("Trà Nhài");
        productDTO.setPrice(12.3);
        productDTO.setImage("https://logyfood.com/wp-content/uploads/2021/07/tra-dao.png");
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setIdType(1);
        productTypeDTO.setNameType("Trà sữa");
        productDTO.setProductTypeDTO(productTypeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/product/update/1")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
