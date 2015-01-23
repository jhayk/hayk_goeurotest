package com.goeuro.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

/**
 * Created by hayk on 1/23/15.
 */
public class JsonHelper {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static String encode(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T decode(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T decode(InputStream stream, Class<T> clazz) {
		try {
			return mapper.readValue(stream, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
