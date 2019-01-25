package com.mabiao.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author created by mabiao on 2018/9/18
 */
@Data
public class Info {
	private Date date;

	public Info() {
	}

	public Info(Date date) {
		this.date = date;
	}
}
