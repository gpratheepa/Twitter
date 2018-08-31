package com.tweets.service;

import com.tweets.model.Tweet;
import com.tweets.model.User;

public interface TwitterUser {
	
	public Tweet[] getUserTweets(String bearerToken, String screenName) throws Exception; 
	
	public User getUserDetail(String bearerToken, String screenName) throws Exception; 
}
