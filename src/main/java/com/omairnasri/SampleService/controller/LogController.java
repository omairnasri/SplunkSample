package com.omairnasri.SampleService.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.omairnasri.SampleService.service.LogService;

@RestController
public class LogController {

	@Autowired
	private LogService logService;

	private JsonArray logData = new JsonArray();

	@PostConstruct
	public void init() {

		try {
			logData = logService.getResourceFileAsString("test.log");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@GetMapping(value = "/", produces = "text/plain")
	public String index() {
		return "navigate to /data to see log data";
	}

	@GetMapping(value = "/data", produces = "application/json")
	public String data() {
		return logData.toString();
	}

}
