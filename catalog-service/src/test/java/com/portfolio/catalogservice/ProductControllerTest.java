package com.portfolio.catalogservice;
import com.portfolio.catalogservice.api.ProductController;
import com.portfolio.catalogservice.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(ProductController.class) class ProductControllerTest {
 @Autowired MockMvc mvc; @MockBean ProductRepository repository;
 @Test void rejectsInvalidProduct() throws Exception { mvc.perform(post("/api/v1/products").contentType(MediaType.APPLICATION_JSON).content("{}" )).andExpect(status().isBadRequest()); }
}
