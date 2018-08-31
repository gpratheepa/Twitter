package com.tweets.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@Override
	public String toString() {
		return "User [screen_name=" + screen_name + ", url=" + url + ", location=" + location + ", profile_image_url="
				+ profile_image_url + "]";
	}
	@JsonProperty("screen_name")
	private String screen_name;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("profile_image_url")
	private String profile_image_url;
	
	@JsonProperty("description")
	private String description;
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfile_image_url() {
		return profile_image_url;
	}
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
