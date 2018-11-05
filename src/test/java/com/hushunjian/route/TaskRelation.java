package com.hushunjian.route;

import lombok.Data;

@Data
public class TaskRelation {
	
	private Long id;
	private Long taskId;
	private Long preTaskId;

	public TaskRelation(Long id, Long taskId, Long preTaskId) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.preTaskId = preTaskId;
	}

	public TaskRelation() {
	}
}
