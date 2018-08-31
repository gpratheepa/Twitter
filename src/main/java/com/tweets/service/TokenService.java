package com.tweets.service;

public interface TokenService {
	
	public String encodeKeys(String consumerKey, String consumerSecret);
	
	public String getBearerToken(String encodeKeys) throws Exception;

}
