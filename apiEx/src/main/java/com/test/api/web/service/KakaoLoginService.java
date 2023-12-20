package com.test.api.web.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.api.util.RestApiUtil;
import com.test.api.web.controller.KakaoLoginController;
import com.test.api.web.model.KakaoAuthResponse;
import com.test.api.web.model.KakaoTokenResponse;


@Service
public class KakaoLoginService {
	private static final Logger logger = LoggerFactory.getLogger(KakaoLoginController.class);
	private static final String ADMINID = "ade649032ccecb8d667540a17f303623";
	
	public KakaoTokenResponse getToken(KakaoAuthResponse response) {
		String url = "https://kauth.kakao.com/oauth/token";
		
		HashMap<String, String> headerData = new HashMap<String, String>();
		headerData.put("Content-type", "Content-type: application/x-www-form-urlencoded;charset=utf-8");
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("grant_type", "authorization_code");
		data.put("client_id", ADMINID);
		data.put("redirect_uri","http://localhost:8090/authResult");
		data.put("code", response.getCode());
		
		KakaoTokenResponse tokenResult = RestApiUtil.ConnHttpGetType(url, headerData, data, KakaoTokenResponse.class);
		logger.info("token result : {}", tokenResult.toString());
		
		return tokenResult;
	}
	
}
