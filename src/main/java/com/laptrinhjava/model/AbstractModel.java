package com.laptrinhjava.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	 private Integer id; 
    private Integer[] idCates;
    private Integer page;
    private Integer maxPageItems;
    private Integer totalPage;
    private Integer totalItem;
    private String sortName, sortBy;

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
    public Integer getPage() {
        return page;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setPage(Integer page) {
        this.page = page;
    }


    public Integer getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(Integer maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer[] getIdCates() {
        return idCates;
    }

    public void setIdCates(Integer[] idCates) {
        this.idCates = idCates;
    }

    private List<T> listResult = new ArrayList<>();

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }
}
