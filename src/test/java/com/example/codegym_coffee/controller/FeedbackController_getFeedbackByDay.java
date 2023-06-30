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
public class FeedbackController_getFeedbackByDay {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach rong, tim kiem dayOfFeedback (null)
     * @throws Exception
     */
    @Test
    public void getFeedbackByDay_dayOfFeedback_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/admin/feedback/search/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, tim kiem dayOfFeedback()
     * @throws Exception
     */
    @Test
    public void getFeedbackByDay_dayOfFeedback_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/admin/feedback/search/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong, tim kiem dayOfFeedback (2024-06-29)
     * @throws Exception
     */
    @Test
    public void getFeedbackByDay_dayOfFeedback_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/admin/feedback/search/2024-06-29"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Danh sach feedback, tim kiem dayOfFeedback (2023-06-09)
     * @throws Exception
     */
    @Test
    public void getFeedbackByDay_dayOfFeedback_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/feedback/search?dayOfFeedback=2023-06-09&page=0&size=10"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].idFeedback").value(14))
                .andExpect(jsonPath("content[0].codeFeedback").value("FB14"))
                .andExpect(jsonPath("content[0].dayOfFeedback").value("2023-06-09"))
                .andExpect(jsonPath("content[0].email").value("huynguyen@gmail.com"))
                .andExpect(jsonPath("content[0].creator").value("Huy Nguyễn"))
                .andExpect(jsonPath("content[0].content").value("Không gian : theo mình thì trong nhà ko rộng lắm, tuy nhiên có bỏ ghế ra đường ngồi nên cũng được. có điều khách đông là cảm thấy ồn ào ngột ngạt ngay"))
                .andExpect(jsonPath("content[1].idFeedback").value(15))
                .andExpect(jsonPath("content[1].codeFeedback").value("FB15"))
                .andExpect(jsonPath("content[1].dayOfFeedback").value("2023-06-09"))
                .andExpect(jsonPath("content[1].email").value("ngocmai@gmail.com"))
                .andExpect(jsonPath("content[1].creator").value("Rùa Con"))
                .andExpect(jsonPath("content[1].content").value("Chất lượng : đồ uống thì quá quá ngon bạn nào mà uống ko quá ngọt nên giảm đường"));
    }
}
