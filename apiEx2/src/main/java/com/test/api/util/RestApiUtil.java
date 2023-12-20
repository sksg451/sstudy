package com.test.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestApiUtil {
	private static final Logger logger = LoggerFactory.getLogger(RestApiUtil.class);
	
	public static <T> T ConnHttpGetType(String conUrl, HashMap<String, String> headerData, 
			HashMap<String, String> data, Class<T> classType){
		try {
			StringBuilder urlBuilder = new StringBuilder(conUrl);

			int count = 0;

			
			for(String key: data.keySet()) {
				if(count==0) {
					urlBuilder.append("?"+URLEncoder.encode(key, "UTF-8")+"="+URLEncoder.encode(data.get(key), "UTF-8"));
				}else {
					urlBuilder.append("&"+URLEncoder.encode(key, "UTF-8")+"="+URLEncoder.encode(data.get(key), "UTF-8"));
				}
				count++;
			}
			
			if(urlBuilder.toString().startsWith("https")) {
				return JsonUtil.parseJson(RestApiUtil.httpsConn(urlBuilder.toString(), headerData), classType);
			}else {
				return JsonUtil.parseJson(RestApiUtil.httpConn(urlBuilder.toString(), headerData), classType);
			}
		} catch (Exception e) {
			logger.error("ConnHttpGetType Error : {}",e);
			return null;
		}
	}
	
	public static String httpsConn(String conUrl, HashMap<String, String> headerData) throws IOException {
		URL url = new URL(conUrl);
		// 서비스를 제공할 API에 파라미터 정보와 함께 요청
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		for(String key: headerData.keySet()) {
			conn.addRequestProperty(key, headerData.get(key));
		}
		BufferedReader rd;
		
		//응답 성공
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <=300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//응답 실패
		}else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}
	
	public static String httpConn(String conUrl, HashMap<String, String> headerData) throws IOException {
		URL url = new URL(conUrl);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		for(String key: headerData.keySet()) {
			conn.addRequestProperty(key, headerData.get(key));
		}
		BufferedReader rd;
		

		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <=300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		}else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}
	
}
