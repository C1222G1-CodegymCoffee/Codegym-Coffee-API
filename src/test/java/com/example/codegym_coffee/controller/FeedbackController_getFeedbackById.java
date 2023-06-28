package com.example.codegym_coffee.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackController_getFeedbackById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach rong, tim kiem id (null)
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/feedback/detail/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, tim kiem id ()
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/feedback/detail/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, tim kiem id (1000) khong co trong database
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/feedback/detail/1000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach feedback, tim kiem id (30)
     * @throws Exception
     */
    @Test
    public void getFeedbackById_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/admin/feedback/detail/30"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("idFeedback").value(30))
                .andExpect(jsonPath("codeFeedback").value("FB30"))
                .andExpect(jsonPath("dayOfFeedback").value("2023-06-21"))
                .andExpect(jsonPath("email").value("quynhdiep@gmail.com"))
                .andExpect(jsonPath("creator").value("Quỳnh Diệp"))
                .andExpect(jsonPath("content").value("Không gian quán rộng thoáng mát"));
    }
}
