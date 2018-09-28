package com.hushunjian.listFilter;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PlanTask {
	private String id;
	
	private String taskName;
	
	private String parent;

	public PlanTask(String id, String taskName, String parent) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.parent = parent;
	}
	
	static {
		final List<PlanTask> list = new ArrayList<>();
		list.add(new PlanTask("2c94808865f5939d0165f5cbe5b20173","测试站点0920",null));
		list.add(new PlanTask("2c94808865f5939d0165f64a828a0484","结构主体施工","2c94808865f5939d0165f5cbe5b20173"));
		list.add(new PlanTask("2c94808865f5939d0165f664ce31050e","安装工程","2c94808865f5939d0165f5cbe5b20173"));
		list.add(new PlanTask("2c94808b65fb00f20165fa30334503e9","装饰施工","2c94808865f5939d0165f5cbe5b20173"));
		list.add(new PlanTask("2c94808865f5939d0165f64a829e0485","主体结构施工","2c94808865f5939d0165f64a828a0484"));
		list.add(new PlanTask("2c94808865f5939d0165f64a829e0485","主体结构施工","2c94808865f5939d0165f64a828a0484"));
		list.add(new PlanTask("","",""));
		list.add(new PlanTask("","",""));
		list.add(new PlanTask("","",""));
	}
	
	
	
	
	
	
	
}
