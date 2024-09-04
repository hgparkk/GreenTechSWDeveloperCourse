package com.spring.study.common.vo;

public class SearchVO {
	private String searchWord;
	private String searchOption;

	private int page = 1;
	private int rowSizePerPage = 10;

	private int start;
	private int end;

	private int firstPage;
	private int lastPage;

	private int totalRow;
	private int totalPage;

	public SearchVO() {
		super();
	}

	public SearchVO(String searchWord, String searchOption, int page, int rowSizePerPage, int start, int end,
			int firstPage, int lastPage, int totalRow, int totalPage) {
		super();
		this.searchWord = searchWord;
		this.searchOption = searchOption;
		this.page = page;
		this.rowSizePerPage = rowSizePerPage;
		this.start = start;
		this.end = end;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.totalRow = totalRow;
		this.totalPage = totalPage;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowSizePerPage() {
		return rowSizePerPage;
	}

	public void setRowSizePerPage(int rowSizePerPage) {
		this.rowSizePerPage = rowSizePerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "SearchVO [searchWord=" + searchWord + ", searchOption=" + searchOption + ", page=" + page
				+ ", rowSizePerPage=" + rowSizePerPage + ", start=" + start + ", end=" + end + ", firstPage="
				+ firstPage + ", lastPage=" + lastPage + ", totalRow=" + totalRow + ", totalPage=" + totalPage + "]";
	}

	public void setTotalInfo(int totalRow) {
		this.totalRow = totalRow;
		this.totalPage = (int) Math.ceil((double) totalRow / rowSizePerPage);

		this.start = rowSizePerPage * (page - 1) + 1;
		this.end = rowSizePerPage * page;

		this.firstPage = (((page - 1) / 10) * 10) + 1;
		this.lastPage = this.firstPage + 9;

		if (this.lastPage >= this.totalPage) {
			this.lastPage = this.totalPage;
		}
	}
}