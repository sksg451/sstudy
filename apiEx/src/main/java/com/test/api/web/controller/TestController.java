package com.test.api.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.web.model.TestResponse;
import com.test.api.web.service.TestService;


@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	TestService testService;
	
	@GetMapping("test")
	public void test() {
		logger.info("test {}");
	}
	
	// @ResponseBody : ajax를 사용하기위해 쓰는 어노테이션
	@ResponseBody
	@GetMapping("/ajaxTest")
	public TestResponse ajaxTest() {
		logger.info("ajaxTest() {} : "+testService.apiTest());
		return testService.apiTest();
	}
}
