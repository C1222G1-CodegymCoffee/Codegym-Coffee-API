package com.example.codegym_coffee.controller.employee;


import com.example.codegym_coffee.dto.account.AccountDTO;
import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.dto.position.PositionDTO;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Position;
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

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_createEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Author:ThangHA
     * Date create: 28/06/2023
     * Function: test  employee null
     *
     * @throws Exception
     */


    @Test
    public void createEmployee_gender_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }


    @Test
    public void createEmployee_name_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_dateOfBirth_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_salary_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_image_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_address_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_phoneNumber_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_email_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_position_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_account_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }


    @Test
    public void createEmployee_name_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_image_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHA");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_address_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHA");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_phoneNumber_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHA");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_email_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHA");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_name_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHA##");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_phoneNumber_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHAT");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0www35195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_email_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHABV");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@@@@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_address_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("ThangHABV");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_name_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Than");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }


    @Test
    public void createEmployee_image_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_salary_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(0);
        employeeDTO.setImage("123131");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_address_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("121231233");
        employeeDTO.setAddress("Chế");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_phoneNumber_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123313");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_phoneNumber_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123132");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("09151958830915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_email_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("h@e.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_email_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganasdfgdfshthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_address_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà NẵngSố 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("h@e.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_nameEmployee_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("HoangAnhThangHoangAnhThangHoangAnhThang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("123123");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("h@e.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_image_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("HoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThangHoangAnhThang");
        employeeDTO.setAddress("Số 123, Đường Lê Lợi, Phường Hòa Cường, Quận Hải Châu, Thành phố Đà Nẵng");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("h@e.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    public void createEmployee_18() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender(true);
        employeeDTO.setNameEmployee("Thang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1995-06-11"));
        employeeDTO.setSalary(1000000);
        employeeDTO.setImage("12323");
        employeeDTO.setAddress("06/04/Chế Lan Viên");
        employeeDTO.setPhoneNumber("0915195883");
        employeeDTO.setEmail("hoanganhthanght@gmail.com");
        Position position = new Position();
        position.setIdPosition((1));
        employeeDTO.setPosition(position);
        Account account = new Account();
        account.setIdAccount(1);
        employeeDTO.setAccount(account);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/home/admin/employee")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }
}
