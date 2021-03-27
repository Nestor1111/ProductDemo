package com.mytheresa.product.ws;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ProductTests {
	
	@Autowired
	MockMvc mvc;

	@Test
	void testProducts() throws Exception {
		this.mvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.products").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.products").isNotEmpty());;
	}

}
