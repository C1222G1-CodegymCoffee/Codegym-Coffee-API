//package com.example.codegym_coffee.controller.employee;
//
//
//import com.example.codegym_coffee.dto.employee.EmployeeDTO;
//import com.example.codegym_coffee.dto.position.PositionDTO;
//import com.example.codegym_coffee.model.Position;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDate;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EmployeeRestController_createEmployee {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private  ObjectMapper objectMapper;
//
//    @Test
//    public void createEmployee_name_14() throws Exception {
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setGender(true);
//        employeeDTO.setNameEmployee("");
//        employeeDTO.setDateOfBirth(LocalDate.ofEpochDay(2024-10-10));
//        employeeDTO.setSalary(1000000);
//        employeeDTO.setImage("123");
//        employeeDTO.setAddress("06/04/Chế Lan Viên");
//        employeeDTO.setPhoneNumber("0915195883");
//        employeeDTO.setEmail("hoanganhthanght@gmail.com");
//
//        Position position = new Position();
//        position.setIdPosition((1));
//        employeeDTO.setPosition(position);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/home/admin/employee")
//                        .content(this.objectMapper.writeValueAsString(employeeDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//
//    }
//    @Test
//    public void createEmployee_address_14() throws Exception {
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setGender(true);
//        employeeDTO.setNameEmployee("Thắng");
//        employeeDTO.setDateOfBirth(LocalDate.ofEpochDay(2024-10-10));
//        employeeDTO.setSalary(1000000);
//        employeeDTO.setImage("123");
//        employeeDTO.setAddress("");
//        employeeDTO.setPhoneNumber("0915195883");
//        employeeDTO.setEmail("hoanganhthanght@gmail.com");
//
//        Position position = new Position();
//        position.setIdPosition((1));
//        employeeDTO.setPosition(position);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/home/admin/employee")
//                        .content(this.objectMapper.writeValueAsString(employeeDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//
//    }
//
//    @Test
//    public void createEmployee_phone_number_number_14() throws Exception {
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setGender(true);
//        employeeDTO.setNameEmployee("Thắng");
//        employeeDTO.setDateOfBirth(LocalDate.ofEpochDay(2024-10-10));
//        employeeDTO.setSalary(1000000);
//        employeeDTO.setImage("123");
//        employeeDTO.setAddress("06/04/Chế Lan Viên");
//        employeeDTO.setPhoneNumber("");
//        employeeDTO.setEmail("hoanganhthanght@gmail.com");
//
//        Position position = new Position();
//        position.setIdPosition((1));
//        employeeDTO.setPosition(position);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/home/admin/employee")
//                        .content(this.objectMapper.writeValueAsString(employeeDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void createEmployee_email_14() throws Exception {
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setGender(true);
//        employeeDTO.setNameEmployee("");
//        employeeDTO.setDateOfBirth(LocalDate.ofEpochDay(2024-10-10));
//        employeeDTO.setSalary(1000000);
//        employeeDTO.setImage("123");
//        employeeDTO.setAddress("06/04/Chế Lan Viên");
//        employeeDTO.setPhoneNumber("0915195883");
//        employeeDTO.setEmail("");
//
//        Position position = new Position();
//        position.setIdPosition((1));
//        employeeDTO.setPosition(position);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/home/admin/employee")
//                        .content(this.objectMapper.writeValueAsString(employeeDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//
//    }
//
//}
