package com.mytheresa.product.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	public static String readFileToString(String path) throws IOException {
        try (InputStream inputStream = Utils.class.getResourceAsStream(path)) {
            String text = new BufferedReader(
            	      new InputStreamReader(inputStream, StandardCharsets.UTF_8))
            	        .lines()
            	        .collect(Collectors.joining());
            return text;
        }
    }
	
	public static <T> List<T> jsonToList(String json, Class<T> classz) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, classz));
    }
	
}
