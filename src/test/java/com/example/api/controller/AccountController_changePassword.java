package com.example.api.controller;

import com.example.codegym_coffee.dto.account.ChangePasswordForm;
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

@SpringBootTest(classes = {com.example.codegym_coffee.SmartCoffeeApplication.class})
@AutoConfigureMockMvc
public class AccountController_changePassword {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test old password null
     * @throws Exception
     */
    @Test
    public void changePassword_oldPassWord_19() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword(null);
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test old password empty
     * @throws Exception
     */
    @Test
    public void changePassword_oldPassWord_20() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: check old password must be at least 5 characters
     * @throws Exception
     */
    @Test
    public void changePassword_oldPassWord_22() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("a");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test old password maximum 20 characters
     * @throws Exception
     */
    @Test
    public void changePassword_oldPassWord_23() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abcaabcabcabababbcabbabacbabacbacbabacbcababcabhgdsgdsgs");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: In case the old password does not exist under the database
     * @throws Exception
     */
    @Test
    public void changePassword_oldPassWord_99() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc11111");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test new password null
     * @throws Exception
     */
    @Test
    public void changePassword_newPassWord_19() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword(null);
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test new password empty
     * @throws Exception
     */
    @Test
    public void changePassword_newPassWord_20() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test the new password must be at least 5 characters
     * @throws Exception
     */
    @Test
    public void changePassword_newPassWord_22() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("a");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test the new password maximum 20 characters
     * @throws Exception
     */
    @Test
    public void changePassword_newPassWord_23() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abcaabcabcabababbcabbabacbabacbacbabacbcababcab");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: The new password is the same as the old password
     * @throws Exception
     */
    @Test
    public void changePassword_newPassWord_99() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc12345");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test confirm password null
     * @throws Exception
     */
    @Test
    public void changePassword_confirmPassword_19() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc123");
        changePasswordForm.setNewPassword("abc12345");
        changePasswordForm.setConfirmPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test confirm password empty
     * @throws Exception
     */
    @Test
    public void changePassword_confirmPassword_20() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc123");
        changePasswordForm.setNewPassword("abc12345");
        changePasswordForm.setConfirmPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test confirm password must be at least 5 characters
     * @throws Exception
     */
    @Test
    public void changePassword_confirmPassword_22() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("a");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test confirm password maximum 20 characters
     * @throws Exception
     */
    @Test
    public void changePassword_confirmPassword_23() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abcaabcabcabababbcabbabacbabacbacbabacbcababcab");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function:  confirm password is the same as the new password
     * @throws Exception
     */
    @Test
    public void changePassword_confirmPassword_99() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc12345555");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test the password successful
     * @throws Exception
     */
    @Test
    public void changePassword_24() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("admin1");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Author:QuynhHTN
     * Date create: 28/06/2023
     * Function: test name account null
     * @throws Exception
     */
    @Test
    public void changePassword_nameAccount_19() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount(null);
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
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
    public void changePassword_nameAccount_20() throws Exception {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
//        changePasswordForm.setNameAccount("");
        changePasswordForm.setOldPassword("abc12345");
        changePasswordForm.setNewPassword("abc123456");
        changePasswordForm.setConfirmPassword("abc123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/account/change-password")
                        .content(this.objectMapper.writeValueAsString(changePasswordForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
