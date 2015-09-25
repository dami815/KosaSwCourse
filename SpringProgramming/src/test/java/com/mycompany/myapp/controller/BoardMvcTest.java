package com.mycompany.myapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mycompany.myapp.ApplicationContextLoader;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BoardMvcTest extends ApplicationContextLoader {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardMvcTest.class);
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		logger.info("setup");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void test1() throws Exception {
		logger.info("test1");
		mockMvc.perform(get("/board/list"))
			.andExpect(model().attributeExists("list"))
			.andExpect(view().name("board/list"))
			.andExpect(status().isOk());
		}
	
	@Test
	public void test2() throws Exception {
		logger.info("test2");
		mockMvc.perform(
				post("/board/write")
					.param("title", "테스트1")
					.param("content", "내용1")
					.param("writer", "글쓴이1")
		)
		.andExpect(redirectedUrl("/board/list"));
			
	}
}
