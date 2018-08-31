package com.tweets.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tweets.model.Tweet;
import com.tweets.model.User;

@Service
public class TwitterUserImpl implements TwitterUser{
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Tweet[] getUserTweets(String bearerToken, String screenName) throws RestClientException, URISyntaxException {
		HttpHeaders bearerHeader = new HttpHeaders();
		bearerHeader.set("Authorization", "Bearer " + bearerToken);
		ResponseEntity<Tweet[]> tweets = restTemplate.exchange(
				new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+screenName+"&count=10"), HttpMethod.GET,
				new HttpEntity<Tweet>(bearerHeader), Tweet[].class);
		
		return tweets.getBody();
	}
	
	
	public User getUserDetail(String bearerToken, String screenName)throws RestClientException, URISyntaxException {
		HttpHeaders bearerHeader = new HttpHeaders();
		bearerHeader.set("Authorization", "Bearer " + bearerToken);
		
		ResponseEntity<User> tweets = restTemplate.exchange(
				new URI("https://api.twitter.com/1.1/users/show.json?screen_name="+screenName), HttpMethod.GET,
				new HttpEntity<String>(bearerHeader), User.class);
		
		return tweets.getBody();
	}

}
