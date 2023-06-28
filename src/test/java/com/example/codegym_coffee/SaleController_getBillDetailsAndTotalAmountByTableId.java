package com.example.codegym_coffee;

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
public class SaleController_getBillDetailsAndTotalAmountByTableId {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBillDetailsAndTotalAmountByTableId_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/bill-details/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getBillDetailsAndTotalAmountByTableId_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/bill-details/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getBillDetailsAndTotalAmountByTableId_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/bill-details/123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/sale/bill-details/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].quantityOfProduct").value(1))
                .andExpect(jsonPath("[0].idBillDetail").value(6))
                .andExpect(jsonPath("[0].nameTable").value("T1-02"))
                .andExpect(jsonPath("[0].price").value(15000.0))
                .andExpect(jsonPath("[0].nameProduct").value("trà sữa"))
                .andExpect(jsonPath("[0].totalPrice").value(15000.0))
                .andExpect(jsonPath("[0].totalAmount").value(75000.0))
                .andExpect(jsonPath("[1].quantityOfProduct").value(4))
                .andExpect(jsonPath("[1].idBillDetail").value(5))
                .andExpect(jsonPath("[1].nameTable").value("T1-02"))
                .andExpect(jsonPath("[1].price").value(15000.0))
                .andExpect(jsonPath("[1].nameProduct").value("cà phê"))
                .andExpect(jsonPath("[1].totalPrice").value(60000.0))
                .andExpect(jsonPath("[1].totalAmount").value(75000.0));
    }

}
