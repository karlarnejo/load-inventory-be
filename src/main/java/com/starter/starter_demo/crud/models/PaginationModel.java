package com.starter.starter_demo.crud.models;

import java.util.ArrayList;
import java.util.List;

public class PaginationModel {

		private List<Object> data;
		private int itemsPerPage;
		private int totalPages;
		private int pageInput;
		
		public PaginationModel() {
			
		}

		public List<Object> getData() {
			return data;
		}

		public void setData(List<Object> data) {
			this.data = new ArrayList<>(data);
		}

		public int getItemsPerPage() {
			return itemsPerPage;
		}

		public void setItemsPerPage(int itemsPerPage) {
			this.itemsPerPage = itemsPerPage;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(int totalPages) {
			this.totalPages = totalPages;
		}

		public int getPageInput() {
			return pageInput;
		}

		public void setPageInput(int pageInput) {
			this.pageInput = pageInput;
		}
}
