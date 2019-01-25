package com.mabiao.domain.web;

/**
 * @author created by mabiao on 2018/7/5
 */
public class PageQuery<T> {

	Integer pagesize;
	String num;
	T model;

	public PageQuery(Integer pagesize, String num) {
		this.pagesize = pagesize;
		this.num = num;
	}

	public PageQuery() {
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "PageQuery{" +
				"pagesize=" + pagesize +
				", num='" + num + '\'' +
				", model=" + model +
				'}';
	}

	public PageQuery(Integer pagesize, String num, T model) {
		this.pagesize = pagesize;
		this.num = num;
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
