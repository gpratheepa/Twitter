package com.tweets.service;

import java.util.List;

import com.tweets.model.Tweet;

public interface TweetSearch {
	
	public List<Tweet>  getSearchedTweets(String bearerToken, String searchText) throws Exception;
	
}
