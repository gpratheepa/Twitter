package com.tweets.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryResult {
	
	@JsonProperty("statuses")
	private List<Tweet> statuses;
	
	@JsonProperty("search_metadata")
	private SearchMetadata search_metadata;
	
	public List<Tweet> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<Tweet> statuses) {
		this.statuses = statuses;
	}
	public SearchMetadata getSearch_metadata() {
		return search_metadata;
	}
	public void setSearch_metadata(SearchMetadata search_metadata) {
		this.search_metadata = search_metadata;
	}

}
