package com.tweets.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entities {
	
	@JsonProperty("hashtags")
	private List<Hashtag> hashtags;

	public List<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}

	@Override
	public String toString() {
		return "Entities [hashtags=" + hashtags + "]";
	}
	
		
}
