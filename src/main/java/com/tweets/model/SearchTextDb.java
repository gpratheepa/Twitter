package com.tweets.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "search")
public class SearchTextDb {
	@Id
	@GeneratedValue
	@Column(name = "search_id")
	private int id;
	
	@Column(name = "search_text", nullable = false)
	private String searchText;
	
	@OneToMany
	 @JoinTable(name = "TweetDB", joinColumns = {@JoinColumn(name="search_id")})
	private Set<TweetDb> tweets;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	

}
