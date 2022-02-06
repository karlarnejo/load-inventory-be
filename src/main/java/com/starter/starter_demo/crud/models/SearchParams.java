package com.starter.starter_demo.crud.models;

public class SearchParams {

	private int pageInput;
	private int itemsPerPage;
	private String searchQuery;
	private String sortDirection;
	private String sortItem;
	
	public SearchParams() {
		
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSortItem() {
		return sortItem;
	}

	public void setSortItem(String sortItem) {
		this.sortItem = sortItem;
	}

	public int getPageInput() {
		return pageInput;
	}

	public void setPageInput(int pageInput) {
		this.pageInput = pageInput;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}	
}
