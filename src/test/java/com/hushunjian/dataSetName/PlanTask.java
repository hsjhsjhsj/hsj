package com.hushunjian.dataSetName;

import lombok.Data;

@Data
public class PlanTask {
	
	private String id;
	
	private String outLineNum;
	
	private String parent;
	
	private String taskName;

	public PlanTask(String id, String outLineNum, String parent, String taskName) {
		super();
		this.id = id;
		this.outLineNum = outLineNum;
		this.parent = parent;
		this.taskName = taskName;
	}
	
	public PlanTask() {
	}
	
	
}
