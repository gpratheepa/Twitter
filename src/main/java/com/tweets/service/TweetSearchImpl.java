package com.tweets.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tweets.model.QueryResult;
import com.tweets.model.Tweet;

@Service
public class TweetSearchImpl implements TweetSearch {
	
	@Autowired
	private RestTemplate restTemplate;

	public List<Tweet> getSearchedTweets(String bearerToken, String searchText) throws RestClientException, URISyntaxException, IOException {
		
		HttpHeaders bearerHeader = new HttpHeaders();
		bearerHeader.set("Authorization", "Bearer " + bearerToken);
		ResponseEntity<QueryResult> tweets = restTemplate.exchange(
				new URI("https://api.twitter.com/1.1/search/tweets.json?q="+URLEncoder.encode(searchText,  "UTF-8")+"&result_type=popular"), HttpMethod.GET,
				new HttpEntity<String>(bearerHeader), QueryResult.class);
		
		return tweets.getBody().getStatuses();
	}
	
	
}
