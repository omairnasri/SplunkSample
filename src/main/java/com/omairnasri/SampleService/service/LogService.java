package com.omairnasri.SampleService.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

@Component
public class LogService {

	public JsonArray getResourceFileAsString(String fileName) throws IOException {
		JsonArray j = new JsonArray();

		InputStream is = getResourceFileAsInputStream(fileName);
		if (is != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			for (String line = null; (line = reader.readLine()) != null;) {
				j.add(line);
			}

			return j;

		} else {
			throw new RuntimeException("resource not found");
		}
	}

	public InputStream getResourceFileAsInputStream(String fileName) {
		ClassLoader classLoader = LogService.class.getClassLoader();
		return classLoader.getResourceAsStream(fileName);
	}

}
