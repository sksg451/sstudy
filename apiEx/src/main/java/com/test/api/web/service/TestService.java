package com.test.api.web.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.test.api.util.RestApiUtil;
import com.test.api.web.model.TestResponse;

@Service
public class TestService {
	private static final String SECRETKEY
	= "TkMG7gCQ65GjZjBosJt7eDK2YxlnB5DBqH1iiI0ux1H9gMMnvA9/yM/3IAQBWVHBXgpVSooBk5qlzW659/Qx2Q==";
	
	public TestResponse apiTest() {
		String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ServiceKey", SECRETKEY);
		data.put("pageNo", "1");
		data.put("numOfRows", "1000");
		data.put("dataType", "JSON");
		data.put("base_date", "20231220");
		data.put("base_time", "0600");
		data.put("nx", "55");
		data.put("ny", "127");
		
		HashMap<String, String> headerData = new HashMap<String, String>();
		// header에 넣을게 없으면 이 정도만 넣어줘도됨
		headerData.put("Content-Type", "application/json");
		
		TestResponse result = RestApiUtil.ConnHttpGetType(url, headerData, data, TestResponse.class);
		
		return result;
	}

}
