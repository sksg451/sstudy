package com.test.api.web.service;

import org.springframework.stereotype.Service;

import com.test.api.web.domain.UserVO;

@Service
public class LoginService {

	public boolean chkLogin(UserVO userParam) {
		// UserVO user 디비 정보 가져오기
		UserVO dbUser = new UserVO();
		dbUser.setUserId("testUser");
		dbUser.setUserPw("testPw");
		
		return (userParam.getUserId().equals(dbUser.getUserId()) && userParam.getUserPw().equals(dbUser.getUserPw()));
	}

}
