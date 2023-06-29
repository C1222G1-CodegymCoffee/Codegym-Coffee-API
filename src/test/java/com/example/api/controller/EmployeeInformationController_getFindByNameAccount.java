package com.example.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {com.example.codegym_coffee.SmartCoffeeApplication.class})
@AutoConfigureMockMvc
public class EmployeeInformationController_getFindByNameAccount {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test name account null
     * @throws Exception
     */
    @Test
    public void getFindByNameAccount_nameAccount_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/employee/detail?nameAccount={nameAccount}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test name account empty
     * @throws Exception
     */
    @Test
    public void getFindByNameAccount_nameAccount_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/employee/detail?nameAccount={nameAccount}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: In case the name account does not exist under the database
     *
     * @throws Exception
     */
    @Test
    public void getFindByNameAccount_nameAccount_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/employee/detail?nameAccount={nameAccount}", "quynh"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test find name account is in database
     * @throws Exception
     */

    @Test
    public void getInfoStudent_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/employee/detail?nameAccount={nameAccount}", "admin1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idEmployee").value(1))
                .andExpect(jsonPath("address").value("Quảng Nam"))
                .andExpect(jsonPath("dateOfBirth").value("1990-06-01"))
                .andExpect(jsonPath("email").value("nguyenvana@gmail.com"))
                .andExpect(jsonPath("gender").value(false))
                .andExpect(jsonPath("image").value("https://haycafe.vn/wp-content/uploads/2021/11/hinh-anh-hoat-hinh-de-thuong-cute-dep-nhat-600x600.jpg"))
                .andExpect(jsonPath("nameEmployee").value("Nguyễn Văn A"))
                .andExpect(jsonPath("phoneNumber").value("0909889789"))
                .andExpect(jsonPath("position.idPosition").value(1))
                .andExpect(jsonPath("account.idAccount").value(1))
        ;
    }
}
