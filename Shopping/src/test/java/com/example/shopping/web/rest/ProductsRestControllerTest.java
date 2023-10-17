package com.example.shopping.web.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void testGetAllProducts() throws Exception {
		when(productService.getAllProducts())
			.thenReturn(List.of(createProduct("ACER", 1500), createProduct("ASUS", 2000)));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].productName", is("ACER")))
			.andExpect(jsonPath("$.[1].productName", is("ASUS")))
			.andExpect(jsonPath("$.[0].id", is(1)))
			.andExpect(jsonPath("$.[1].id", is(1)));
	}

	private ProductViewDto createProduct(String name, int price) {
		ProductViewDto product = new ProductViewDto(1l, name, BigDecimal.valueOf(price), "path");

		return product;
	}
}
