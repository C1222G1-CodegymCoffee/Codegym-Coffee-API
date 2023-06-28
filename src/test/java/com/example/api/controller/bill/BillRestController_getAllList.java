    package com.example.api.controller.bill;

    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @SpringBootTest
    @AutoConfigureMockMvc
    public class BillRestController_getAllList {
        @Autowired
        private MockMvc mockMvc;

        /**
         *This method is used to check the returned list is of size 0
         * @throws Exception
         */
        @Test
        public void getListBill_5() throws Exception {
            this.mockMvc.perform(MockMvcRequestBuilders.get("api/admin/bill"))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        }
    }
