package com.example.codegym_coffee.controller.employee;

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
public class EmployeeRestController_findByName {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach rong, tim kiem name (null)
     * @throws Exception
     */
    @Test
    public void getEmployeeByName_title_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/home/admin/employee/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Danh sach rong, tim kiem name (1000) khong co trong database
     * @throws Exception
     */
    @Test
    public void getEmployeeByName_title_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/home/admin/employee/1000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach employee, tim kiem name (Hien)
     * @throws Exception
     */
    @Test
    public void getEmployeeByName_title_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/home/admin/employee/Hien"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("nameEmployee").value(30))
                .andExpect(jsonPath("gender").value(true))
                .andExpect(jsonPath("dateOfBirth").value("2023-06-21"))
                .andExpect(jsonPath("email").value("quynhdiep@gmail.com"))
                .andExpect(jsonPath("salary").value(10000000))
                .andExpect(jsonPath("image").value("12345"))
                .andExpect(jsonPath("address").value("Đà Nẵng"))
                .andExpect(jsonPath("phoneNumber").value("0915195883"));
    }
}
