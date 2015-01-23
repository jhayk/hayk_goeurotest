package com.goeuro.helpers;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hayk on 1/23/15.
 */
public class HttpHelper {
	public static int CONNECTION_TIME_OUT = 20000;
	public static int READ_TIME_OUT = 40000;

	public static Object doGet(String path) {
		return doRequest(path, "GET");
	}

	public static Object doRequest(String path, String method) {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(path);
			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(CONNECTION_TIME_OUT);
			connection.setReadTimeout(READ_TIME_OUT);
			connection.setRequestMethod(method);
			connection.setDoOutput(false);
			Object result = IOUtils.toString(connection.getInputStream(), "UTF-8");
			return result;
		} catch (IOException ex) {
			ex.printStackTrace();
			return ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
