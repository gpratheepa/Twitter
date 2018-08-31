package com.tweets.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {
	
	@JsonProperty("created_at")
	private String created_at;
	
	@JsonProperty("id_str")
	private String id_str;
	
	@JsonProperty("text")
	private String text;
	
	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
	}
	@JsonProperty("user")
	private User user;
	
	@JsonProperty("entities")
	private Entities entities;
	
	public String getId_str() {
		return id_str;
	}
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Tweet [created_at=" + created_at + ", id_str=" + id_str + ", text=" + text + ", user=" + user
				+ ", entities=" + entities + "]\n";
	}

}
