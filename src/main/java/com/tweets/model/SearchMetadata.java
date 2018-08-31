package com.tweets.model;

public class SearchMetadata {

	private String max_id_str;
	private String next_results;
	private String since_id_str;
	private String query;
	private Integer count;
	private Long max_id;
	private Long since_id;
	private Double completed_in;
	public String getMax_id_str() {
		return max_id_str;
	}
	public void setMax_id_str(String max_id_str) {
		this.max_id_str = max_id_str;
	}
	public String getNext_results() {
		return next_results;
	}
	public void setNext_results(String next_results) {
		this.next_results = next_results;
	}
	public String getSince_id_str() {
		return since_id_str;
	}
	public void setSince_id_str(String since_id_str) {
		this.since_id_str = since_id_str;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Long getMax_id() {
		return max_id;
	}
	public void setMax_id(Long max_id) {
		this.max_id = max_id;
	}
	public Long getSince_id() {
		return since_id;
	}
	public void setSince_id(Long since_id) {
		this.since_id = since_id;
	}
	public Double getCompleted_in() {
		return completed_in;
	}
	public void setCompleted_in(Double completed_in) {
		this.completed_in = completed_in;
	}
	
}
