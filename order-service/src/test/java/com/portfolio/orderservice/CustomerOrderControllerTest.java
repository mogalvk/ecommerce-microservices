package com.portfolio.orderservice;
import com.portfolio.orderservice.api.CustomerOrderController;
import com.portfolio.orderservice.repo.CustomerOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(CustomerOrderController.class) class CustomerOrderControllerTest {
 @Autowired MockMvc mvc; @MockBean CustomerOrderRepository repository;
 @Test void rejectsInvalidOrder() throws Exception { mvc.perform(post("/api/v1/orders").contentType(MediaType.APPLICATION_JSON).content("{}" )).andExpect(status().isBadRequest()); }
}
