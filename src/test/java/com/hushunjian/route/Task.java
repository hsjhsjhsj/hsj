package com.hushunjian.route;

import lombok.Data;

@Data
public class Task {
	
	private Long id;
	private String taskName;
	
	public Task(Long id, String taskName) {
		super();
		this.id = id;
		this.taskName = taskName;
	}
	public Task() {
	}
}
