package com.mabiao.domain.web;

import lombok.Data;

/**
 * @author created by mabiao on 2018/6/16
 */
@Data
public class User {
	private Integer id;
	private String username;
	private String password;

	public User(Integer id) {
		this.id = id;
	}
}
