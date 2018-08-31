package com.tweets.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.tweets.model.AccessToken;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private RestTemplate restTemplate;

	public String encodeKeys(String consumerKey, String consumerSecret) {
		try {
			String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
			String encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");

			String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;
			byte[] encodedBytes = Base64.encodeBase64(fullKey.getBytes());
			return new String(encodedBytes);
		} catch (UnsupportedEncodingException e) {
			return new String();
		}
	}

	public String getBearerToken(String encodeKeys) throws RestClientException, URISyntaxException {
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", "Basic " + encodeKeys);
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);
		ResponseEntity<String> accessToken = restTemplate.exchange(new URI("https://api.twitter.com/oauth2/token"),
				HttpMethod.POST, httpEntity, String.class);
		String tokenJson = accessToken.getBody();
		Gson gson = new Gson(); 
		AccessToken bearerAccessToken = gson.fromJson(tokenJson, AccessToken.class); 
		return bearerAccessToken.getAccess_token();
	} 
}
