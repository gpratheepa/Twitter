package com.tweets.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hashtag {
	
	@JsonProperty("text")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Hashtag [text=" + text + "]";
	}
	
		
}
