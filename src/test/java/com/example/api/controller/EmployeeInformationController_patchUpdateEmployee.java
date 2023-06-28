package com.example.api.controller;

import com.example.codegym_coffee.dto.account.PositionDTO;
import com.example.codegym_coffee.dto.employee.EmployeeUpdateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {com.example.codegym_coffee.SmartCoffeeApplication.class})
@AutoConfigureMockMvc
public class EmployeeInformationController_patchUpdateEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void patchUpdateEmployee_nameEmployee_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee(null);
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_phoneNumber_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber(null);
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_address_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress(null);
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_dateOfBirth_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(null);
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_image_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage(null);
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_salary_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(null);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_gender_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(null);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_IdPosition_19() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(null);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_nameEmployee_20() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_phoneNumber_20() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_address_20() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_dateOfBirth_20() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_image_20() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_salary_20() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_nameEmployee_21() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh#*");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_phoneNumber_21() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566#abc");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void patchUpdateEmployee_image_21() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg#gg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_nameEmployee_22() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoa");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void patchUpdateEmployee_salary_22() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(0.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
@Test
    public void patchUpdateEmployee_nameEmployee_23() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void patchUpdateEmployee_salary_24() throws Exception {
        EmployeeUpdateDTO employeeUpdateDTO = new EmployeeUpdateDTO();
        employeeUpdateDTO.setNameEmployee("Hoàng Thị Như Quỳnh");
        employeeUpdateDTO.setPhoneNumber("0368581566");
        employeeUpdateDTO.setAddress("Đà Nẵng");
        employeeUpdateDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeUpdateDTO.setImage("https://i.pinimg.com/originals/08/c4/5e/08c45e81e82033a7bafa3728575aebd5.jpg");
        employeeUpdateDTO.setSalary(6000000.0);
        employeeUpdateDTO.setGender(true);
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setIdPosition(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .content(this.objectMapper.writeValueAsString(employeeUpdateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
