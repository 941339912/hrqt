package cn.bdqn.utils;

public class Page {
	public Page() {
		super();
	}

	private int currPage = 1;//当前页码
	private int pageSize;//每页显示条数
	private int totalCount;//总记录数
	private int totalPageCount;//总页数

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize == 0) {
			this.pageSize =6;
		}else {
			this.pageSize = pageSize;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;

			totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
					: (totalCount / pageSize) + 1;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

}
