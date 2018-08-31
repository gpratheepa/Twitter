package com.tweets.model;
/*
 { token_type: 'bearer',
  access_token: 'AAAAAAAAAAAAAAAAAAAAAM0D4wAAAAAAwKloYueItGpewn%2F67Y9KbL1Qiso%3DZguLaCWwaeZ2Q6BDuOwQKQ0enlJDNbnI5pltBSbROm2e1pLuEt' }
 */
public class AccessToken {
	private String token_type;
	private String access_token;
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
