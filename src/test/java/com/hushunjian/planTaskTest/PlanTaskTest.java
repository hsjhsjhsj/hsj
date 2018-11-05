package com.hushunjian.planTaskTest;

import java.util.ArrayList;
import java.util.List;

import com.hushunjian.dataSetName.PlanTask;

public class PlanTaskTest {

	private final static List<PlanTask> list1 = new ArrayList<>();
	
	static{
		list1.add(new PlanTask("1","1",null,"任务1"));
		list1.add(new PlanTask("2","1.1",null,"任务2"));
		list1.add(new PlanTask("3","1.1.1",null,"任务3"));
		list1.add(new PlanTask("4","1.1.1.1",null,"任务4"));
		list1.add(new PlanTask("5","1.1.1.1.1",null,"任务5"));
		list1.add(new PlanTask("6","1.1.1.1.1.1",null,"任务6"));
		list1.add(new PlanTask("7","1.1.1.1.1.1.1",null,"任务7"));
	}
	
	
}
