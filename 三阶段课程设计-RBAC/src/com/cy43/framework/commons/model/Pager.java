package com.cy43.framework.commons.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pager {

	private int pageNow = 1;
	private int pageSize = 2;

	private int totalCount ;
	private int totalPages ;

	private int offset;

	private List<?> datas;//存储结果集

	private Map<String,String> query = new HashMap<String,String>();

	public int getPageNow() {
		return this.pageNow;
	}

	public void setPageNow( int pageNow ) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize( int pageSize ) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount( int totalCount ) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		int flag = this.totalCount%this.pageSize;
		int totalPages = this.totalCount/this.pageSize;
		return flag==0?totalPages:totalPages+1;
	}

	public void setTotalPages( int totalPages ) {
		this.totalPages = totalPages;
	}

	public int getOffset() {
		return (this.pageNow-1)*this.pageSize;
	}

	public void setOffset( int offset ) {
		this.offset = offset;
	}

	public List<?> getDatas() {
		return this.datas;
	}

	public void setDatas( List<?> datas ) {
		this.datas = datas;
	}

	public Map<String, String> getQuery() {
		return this.query;
	}

	public void setQuery( Map<String, String> query ) {
		this.query = query;
	}


}
