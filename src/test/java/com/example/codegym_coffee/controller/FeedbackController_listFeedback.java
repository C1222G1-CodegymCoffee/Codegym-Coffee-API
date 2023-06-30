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
public class FeedbackController_listFeedback {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Danh sach rong, database rong
     * @throws Exception
     */
    @Test
    public void listFeedback_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/feedback/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach feedback page 1
     * @throws Exception
     */
    @Test
    public void listFeedback_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admin/feedback/?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(30))
                .andExpect(jsonPath("content[0].idFeedback").value(20))
                .andExpect(jsonPath("content[0].codeFeedback").value("FB20"))
                .andExpect(jsonPath("content[0].dayOfFeedback").value("2023-06-15"))
                .andExpect(jsonPath("content[0].email").value("thuyha@gmail.com"))
                .andExpect(jsonPath("content[0].creator").value("Thúy Hà Nguyễn Kim"))
                .andExpect(jsonPath("content[0].content").value("Các dòng thức uống khác đều ngon, nếu không muốn đợi quá lâu thì nên tới quán sớm sớm nha."))
                .andExpect(jsonPath("content[9].idFeedback").value(12))
                .andExpect(jsonPath("content[9].codeFeedback").value("FB12"))
                .andExpect(jsonPath("content[9].dayOfFeedback").value("2023-06-08"))
                .andExpect(jsonPath("content[9].email").value("phuongthuy@gmail.com"))
                .andExpect(jsonPath("content[9].creator").value("Phuong Thuy Pham"))
                .andExpect(jsonPath("content[9].content").value("cảm nhận của mình là không gian của quán đẹp, sạch sẽ,thoáng mát,đồ uống ngon"));
    }

}
