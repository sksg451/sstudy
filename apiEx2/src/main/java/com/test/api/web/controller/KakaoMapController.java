package com.test.api.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class KakaoMapController {
	
	@RequestMapping(value = "/map")
	public void MapView() {
		
	}
}
