package com.qa.DropList.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.DropList.domain.Brand;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads context and boots up on different port
@AutoConfigureMockMvc // tells Spring to setup the mockmvc object
@ActiveProfiles("test") // sets the active profile to 'test'
// runs the sql files before each test method
@Sql(scripts = {"classpath:sql-schema.sql", "classpath:sql-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class BrandControllerIntegrationTest {

	@Autowired // tells spring to inject in the mockmvc object
	private MockMvc mvc; // library that performs the requests

	@Autowired
	private ObjectMapper mapper; // the actual object Spring uses to convert Java <-> JSON

	@Test
	void testCreate() throws Exception {
		// body, method, content-type, url
		Brand offwhite = new Brand("Off-White", "Streetwear");
		String offwhiteAsJSON = this.mapper.writeValueAsString(offwhite);
		RequestBuilder request = post("/brand/create").contentType(MediaType.APPLICATION_JSON).content(offwhiteAsJSON);

		ResultMatcher checkStatus = status().isCreated(); // matcher that we will use to test the response

		Brand offwhiteSaved = new Brand(2L, "Off-White", "Streetwear");
		String offwhiteSavedAsJSON = this.mapper.writeValueAsString(offwhiteSaved);

		ResultMatcher checkBody = content().json(offwhiteSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGet() throws Exception {
		Brand assc = new Brand(1L, "Anti Social Social Club", "Streetwear");
		String asscAsJSON = this.mapper.writeValueAsString(assc);
		RequestBuilder request = get("/brand/getById/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(asscAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Brand assc = new Brand(1L, "Anti Social Social Club", "Streetwear");
		String BrandsJSON = this.mapper.writeValueAsString(List.of(assc));
		RequestBuilder request = get("/brand/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(BrandsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetByUsername() throws Exception {
		Brand assc = new Brand(1L, "Anti Social Social Club", "Streetwear");
		String asscAsJSON = this.mapper.writeValueAsString(assc);
		RequestBuilder request = get("/brand/getByBrandName/" + assc.getBrandName());

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(asscAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdate() throws Exception {
		Brand offwhite = new Brand("Off-White", "Streetwear");
		String offwhiteAsJSON = this.mapper.writeValueAsString(offwhite);
		RequestBuilder request = put("/brand/update/1").contentType(MediaType.APPLICATION_JSON).content(offwhiteAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); // matcher that we will use to test the response

		Brand offwhiteSaved = new Brand(1L, "Off-White", "Streetwear");
		String offwhiteSavedAsJSON = this.mapper.writeValueAsString(offwhiteSaved);

		ResultMatcher checkBody = content().json(offwhiteSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/brand/delete/1")).andExpect(status().isNoContent());
	}
}
