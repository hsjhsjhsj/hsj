package com.hushunjian.testEquest;

import lombok.Data;

@Data
public class User {
	
	private String userName;
	
	private Integer age;
	
	private Long id;

	public User(String userName, Integer age, Long id) {
		super();
		this.userName = userName;
		this.age = age;
		this.id = id;
	}

	public User() {
		super();
	}
}
