package com.test.api.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.api.web.model.KakaoAuthResponse;
import com.test.api.web.service.KakaoLoginService;


@Controller
public class KakaoLoginController {
	private static final Logger logger = LoggerFactory.getLogger(KakaoLoginController.class);
	@Autowired
	KakaoLoginService kakaoLoginService;
	
	@GetMapping("/login")
	public void loginView() {}
	
	@GetMapping("/authResult")
	public String authResult(KakaoAuthResponse response) {
		logger.info("succes auth0-code{}", response.getCode());
		kakaoLoginService.getToken(response);
		return "login";
	}
}
