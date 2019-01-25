package com.mabiao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author created by mabiao on 2018/8/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String name;
	private Integer age;

	public void sayHello(){
		System.out.println("hello");
	}

	public User(String name) {
		this.name = name;
	}
}
