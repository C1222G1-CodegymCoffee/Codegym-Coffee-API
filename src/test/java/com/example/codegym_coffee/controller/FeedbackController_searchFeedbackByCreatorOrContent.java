package com.example.codegym_coffee.controller;

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
public class FeedbackController_searchFeedbackByCreatorOrContent {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach rong, tim kiem searchTerm(null)
     * @throws Exception
     */
    @Test
    public void searchFeedbackByCreatorOrContent_searchTerm_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/admin/feedback/searchTerm/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, tim kiem searchTerm()
     * @throws Exception
     */
    @Test
    public void searchFeedbackByCreatorOrContent_searchTerm_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/admin/feedback/searchTerm/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Danh sach rong, tim kiem searchTerm(gfgdfgdfgd)
     * @throws Exception
     */
    @Test
    public void searchFeedbackByCreatorOrContent_searchTerm_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/admin/feedback/searchTerm/gfgdfgdfgd"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, tim kiem searchTerm(đẹp)
     * @throws Exception
     */
    @Test
    public void searchFeedbackByCreatorOrContent_searchTerm_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/admin/feedback/searchTerm/đẹp"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].idFeedback").value(17))
                .andExpect(jsonPath("content[0].codeFeedback").value("FB17"))
                .andExpect(jsonPath("content[0].dayOfFeedback").value("2023-06-11"))
                .andExpect(jsonPath("content[0].email").value("hangnguyen@gmail.com"))
                .andExpect(jsonPath("content[0].creator").value("Lười Ỉn"))
                .andExpect(jsonPath("content[0].content").value("Bao bì đóng gói đẹp, nhân viên nhiệt tình chu đáo. Mặt bằng quê mình rộng nên ngồi nói chuyện cũng ok."))
                .andExpect(jsonPath("content[1].idFeedback").value(12))
                .andExpect(jsonPath("content[1].codeFeedback").value("FB12"))
                .andExpect(jsonPath("content[1].dayOfFeedback").value("2023-06-08"))
                .andExpect(jsonPath("content[1].email").value("phuongthuy@gmail.com"))
                .andExpect(jsonPath("content[1].creator").value("Phuong Thuy Pham"))
                .andExpect(jsonPath("content[1].content").value("cảm nhận của mình là không gian của quán đẹp, sạch sẽ,thoáng mát,đồ uống ngon"));
    }
}
