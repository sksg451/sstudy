package com.test.api.web.model;

import lombok.Data;

@Data
public class KakaoAuthResponse {
	String code;
	String error;
	String error_description;
	String state;
}
