package com.test.api.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.api.web.domain.UserVO;
import com.test.api.web.service.LoginService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping("/")
	public String loginView() {
		log.info("loginView()");
		return "login/login";
	}
	
	@GetMapping("/main")
	public String mainView() {
		log.info("mainview");
		return "main/main";
	}
	
	@ResponseBody
	@PostMapping("/chkLoginAjax")
	public String chkLoginAjax(HttpSession session, UserVO userParam) {
		log.info("chkLoginAjax userID:"+userParam.getUserId());
		// 실제 로그인 서비스
		
		if(loginService.chkLogin(userParam)) {
			session.setAttribute("userInfo", userParam);
			return "success";
		}else {
			
			return "fail";
		}
	}
	
	@GetMapping("/logout")
	public String logoutView(HttpSession session) {
		session.removeAttribute("userInfo");
		
		return "login/login";
	}
}
