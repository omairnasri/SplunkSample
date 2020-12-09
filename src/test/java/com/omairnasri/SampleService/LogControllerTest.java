package com.omairnasri.SampleService;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

@WebMvcTest
public class LogControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	protected JsonArray stringToJson(String json) {
		JsonParser parse = new JsonParser();
		return parse.parse(json).getAsJsonArray();
	}

	@Test
	public void testGetData() throws Exception {
		final String uri = "/data";
		final String testData = "[2020-12-09 03:11:08] INFO: my application logger: test application log data 0";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		JsonArray logData = stringToJson(content);
		Assert.assertEquals(testData, logData.get(0).getAsString());
		Assert.assertEquals(logData.size(), 1200);
	}

}
