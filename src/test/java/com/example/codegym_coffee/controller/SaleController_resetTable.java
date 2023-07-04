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
public class SaleController_resetTable {

    @Autowired
    private MockMvc mockMvc;

    /**
     * @Author: KhaiNLV
     * This a method use check the return getBillDetailsAndTotalAmountByTableId which param id = null
     * @Throws Exception
     */
    @Test
    public void getBillDetailsAndTotalAmountByTableId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/reset/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: KhaiNLV
     * This a method use check the return getBillDetailsAndTotalAmountByTableId ticket which param id = ''
     * @Throws Exception
     */
    @Test
    public void getBillDetailsAndTotalAmountByTableId_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/reset/''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: KhaiNLV
     * This a method use check the return getBillDetailsAndTotalAmountByTableId id that is not in the database
     * @Throws Exception
     */
    @Test
    public void getBillDetailsAndTotalAmountByTableId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/reset/123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: KhaiNLV
     * This a method use check the return getBillDetailsAndTotalAmountByTableId id contained in the database
     * @Throws Exception
     */
    @Test
    public void getBillDetailsAndTotalAmountByTableId_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/reset/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Author: KhaiNLV
     * This a method use check the return getBillDetailsAndTotalAmountByTableId which param id = 2
     * @Throws Exception
     */
    @Test
    public void getBillDetailsAndTotalAmountByTableId_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/reset/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].quantityOfProduct").value(2))
                .andExpect(jsonPath("[0].idBillDetail").value(1))
                .andExpect(jsonPath("[0].nameTable").value("T1-01"))
                .andExpect(jsonPath("[0].price").value(15000.0))
                .andExpect(jsonPath("[0].nameProduct").value("trà sữa"))
                .andExpect(jsonPath("[0].totalPrice").value(30000.0))
                .andExpect(jsonPath("[0].totalAmount").value(105000.0))
                .andExpect(jsonPath("[1].quantityOfProduct").value(2))
                .andExpect(jsonPath("[1].idBillDetail").value(2))
                .andExpect(jsonPath("[1].nameTable").value("T1-01"))
                .andExpect(jsonPath("[1].price").value(15000.0))
                .andExpect(jsonPath("[1].nameProduct").value("trà sữa"))
                .andExpect(jsonPath("[1].totalPrice").value(30000.0))
                .andExpect(jsonPath("[1].totalAmount").value(105000.0))
                .andExpect(jsonPath("[2].quantityOfProduct").value(2))
                .andExpect(jsonPath("[2].idBillDetail").value(3))
                .andExpect(jsonPath("[2].nameTable").value("T1-01"))
                .andExpect(jsonPath("[2].price").value(15000.0))
                .andExpect(jsonPath("[2].nameProduct").value("trà sữa"))
                .andExpect(jsonPath("[2].totalPrice").value(30000.0))
                .andExpect(jsonPath("[2].totalAmount").value(105000.0))
                .andExpect(jsonPath("[3].quantityOfProduct").value(1))
                .andExpect(jsonPath("[3].idBillDetail").value(4))
                .andExpect(jsonPath("[3].nameTable").value("T1-01"))
                .andExpect(jsonPath("[3].price").value(15000.0))
                .andExpect(jsonPath("[3].nameProduct").value("cà phê"))
                .andExpect(jsonPath("[3].totalPrice").value(15000.0))
                .andExpect(jsonPath("[3].totalAmount").value(105000.0));
    }

}
