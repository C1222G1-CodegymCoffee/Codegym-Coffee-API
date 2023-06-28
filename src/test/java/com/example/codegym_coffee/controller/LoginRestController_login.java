package com.example.codegym_coffee.controller;


import com.example.codegym_coffee.dto.accountDTO.AuthRequest;
import com.example.codegym_coffee.model.Employee;
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
public class LoginRestController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void login_nameAccount_13() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("123456");
        authRequest.setPassword("admin123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_13() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("admin");
        authRequest.setPassword("123abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_nameAccount_14() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("");
        authRequest.setPassword("admin123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_14() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("admin");
        authRequest.setPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_15() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("admin");
        authRequest.setPassword("123456");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_nameAccount_16() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("ad");
        authRequest.setPassword("admin123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_16() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("admin");
        authRequest.setPassword("ad1");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_nameAccount_17() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("adminnnn");
        authRequest.setPassword("admin123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_17() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("admin");
        authRequest.setPassword("ad11111111");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_18() throws Exception {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setNameAccount("admin");
        authRequest.setPassword("admin123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/login")
                        .content(this.objectMapper.writeValueAsString(authRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void processForgotPassword_() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/forgot_password")
                        .content(this.objectMapper.writeValueAsString(""))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void processForgotPassword_13() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/forgot_password")
                        .content(this.objectMapper.writeValueAsString("hoang@gmail.com"))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void processForgotPassword_14() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/forgot_password")
                        .content(this.objectMapper.writeValueAsString(""))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void processForgotPassword_15() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/forgot_password")
                        .content(this.objectMapper.writeValueAsString("abcxyz"))
                        .content(this.objectMapper.writeValueAsString("123456"))
                        .content(this.objectMapper.writeValueAsString("asd@212"))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void processForgotPassword_18() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/forgot_password")
                        .content(this.objectMapper.writeValueAsString("nvhoang020100@gmail.com"))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
