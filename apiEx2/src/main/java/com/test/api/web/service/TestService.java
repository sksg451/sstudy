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
		String url = "http://apis.data.go.kr/1480523/MetalMeasuringResultService/MetalService";
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("ServiceKey", SECRETKEY);
		data.put("pageNo", "1");
		data.put("numOfRows", "10");
		data.put("resultType", "JSON");
		data.put("date", "20171208");
		data.put("stationcode", "1");
		data.put("itemcode", "90303");
		data.put("timecode", "RH02");
		
		HashMap<String, String> headerData = new HashMap<String, String>();
		// header에 넣을게 없으면 이 정도만 넣어줘도됨
		headerData.put("Content-Type", "application/json");
		
		TestResponse result = RestApiUtil.ConnHttpGetType(url, headerData, data, TestResponse.class);
		
		return result;
	}

}
