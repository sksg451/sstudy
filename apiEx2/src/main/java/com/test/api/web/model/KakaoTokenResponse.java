package com.test.api.web.model;

import lombok.Data;

@Data
public class KakaoTokenResponse {
	String token_type;
	String access_token;
	String id_token;
	Integer expires_in;
	String refresh_token;
	Integer refresh_token_expires_in;
	String scope;
}
