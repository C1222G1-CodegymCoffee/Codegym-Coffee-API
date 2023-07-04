//package com.example.codegym_coffee.controller.employee;
//
//import com.example.codegym_coffee.model.Position;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EmployeeRestController_listEmployee {
//
//    @Autowired
//    private MockMvc mockMvc;
//
////    @Test
////    public void getListEmployee_5() throws Exception {
////
////        this.mockMvc.perform(
////                        MockMvcRequestBuilders
////                                .get("/home/admin/employee"))
////                .andDo(print())
////                .andExpect(status().is4xxClientError());
////    }
//
//    @Test
//    public void getListEmployee_6() throws Exception {
//
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("http://localhost:8080/home/admin/employee"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("totalPages").value(1))
//                .andExpect(jsonPath("totalElements").value(2))
//                .andExpect(jsonPath("content[0].nameEmployee").value("Hoàng Anh Thắng"))
//                .andExpect(jsonPath("content[0].dateOfBirth").value("2004-03-10"))
//                .andExpect(jsonPath("content[0].gender").value(true))
//                .andExpect(jsonPath("content[0].salary").value(10000000))
//                .andExpect(jsonPath("content[0].image").value("123"))
//                .andExpect(jsonPath("content[0].address").value("Đà Nẵng"))
//                .andExpect(jsonPath("content[0].phoneNumber").value("0915195883"))
//                .andExpect(jsonPath("content[0].email").value("hoanganhthanght@gmail.com"))
//                .andExpect(jsonPath("content[0].position.idPosition").value(1))
//                .andExpect(jsonPath("content[0].account.idAccount").value(1));
//
//    }
//}
