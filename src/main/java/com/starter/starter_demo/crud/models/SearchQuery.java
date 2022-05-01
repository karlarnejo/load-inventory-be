package com.starter.starter_demo.crud.models;

public class SearchQuery {
	private String searchQuery;
	private String providerId;

	public SearchQuery() {
		
	}
	
	public SearchQuery (String searchQuery, String providerId) {
		
	}
	
	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
}
