package com.tweets.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class TweetDb {
	@Column(name = "created_at")
	private String created_at;
	
	@Id
	@Column(name = "id_str")
	private String id_str;
	
	@Column(name = "text")
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "search_id")
	private SearchTextDb search;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SearchTextDb getSearch() {
		return search;
	}

	public void setSearch(SearchTextDb search) {
		this.search = search;
	}

}
