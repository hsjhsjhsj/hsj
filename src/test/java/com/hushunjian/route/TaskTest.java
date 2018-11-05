package com.hushunjian.route;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskTest {
	
	private static final List<Task> tasks = new ArrayList<>();
	
	private static final List<TaskRelation> taskRelations = new ArrayList<>();
	
	static{
		tasks.add(new Task(1L,"1"));
		tasks.add(new Task(2L,"2"));
		tasks.add(new Task(3L,"3"));
		tasks.add(new Task(4L,"4"));
		tasks.add(new Task(5L,"5"));
		tasks.add(new Task(6L,"6"));
		tasks.add(new Task(7L,"7"));
		tasks.add(new Task(8L,"8"));
		tasks.add(new Task(9L,"9"));
		tasks.add(new Task(10L,"10"));
	}
	
	static{
		taskRelations.add(new TaskRelation(1L,2L,1L));
		taskRelations.add(new TaskRelation(2L,6L,1L));
		taskRelations.add(new TaskRelation(3L,7L,1L));
		taskRelations.add(new TaskRelation(4L,6L,2L));
		taskRelations.add(new TaskRelation(5L,6L,3L));
		taskRelations.add(new TaskRelation(6L,6L,4L));
		taskRelations.add(new TaskRelation(7L,6L,5L));
		taskRelations.add(new TaskRelation(8L,3L,2L));
		taskRelations.add(new TaskRelation(9L,4L,3L));
		taskRelations.add(new TaskRelation(10L,5L,4L));
		taskRelations.add(new TaskRelation(11L,7L,6L));
		taskRelations.add(new TaskRelation(12L,7L,5L));
		taskRelations.add(new TaskRelation(13L,8L,2L));
		taskRelations.add(new TaskRelation(14L,2L,9L));
	}
	
	public static void main(String[] args) {
		// 获取所有的任务id
		List<Long> allTaskIds = tasks.stream().map(Task::getId).collect(Collectors.toList());
		List<Long> allTaskIds1 = tasks.stream().map(Task::getId).collect(Collectors.toList());
		List<Long> allTaskIds2 = tasks.stream().map(Task::getId).collect(Collectors.toList());
		System.out.println("所有的任务id:");
		System.out.println(allTaskIds);
		// 获取开始节点任务[开始节点任务 = 该任务没有前置任务 = 该任务id不出现在任务关联关系的taskId字段]
		Set<Long> taskIds1 = taskRelations.stream().map(TaskRelation::getTaskId).collect(Collectors.toSet());
		System.out.println("有前置任务的id:");
		System.out.println(taskIds1);
		System.out.println("开始节点任务id:");
		allTaskIds1.removeAll(taskIds1);
		System.out.println(allTaskIds1);
		// 获取结束节点任务[结束节点任务 = 该任务没有后置任务 = 该任务id不出现在任务关联关系的preTaskId字段]
		Set<Long> taskIds2 = taskRelations.stream().map(TaskRelation::getPreTaskId).collect(Collectors.toSet());
		System.out.println("有后置任务的id:");
		System.out.println(taskIds2);
		System.out.println("结束节点任务id:");
		allTaskIds2.removeAll(taskIds2);
		System.out.println(allTaskIds2);
		System.out.println("==========<>==========");
		allTaskIds1.forEach(taskId -> findPostTaskA(taskId,taskId.toString()));
		
	}
	
	private static void findPostTaskA(Long id, String path){
		Map<Long, List<TaskRelation>> preTaskIds = taskRelations.stream().collect(Collectors.groupingBy(TaskRelation::getPreTaskId));
		if(preTaskIds.get(id) == null){
			System.out.println(path);
			return;
		}
		List<Long> taskIds = preTaskIds.get(id).stream().map(TaskRelation::getTaskId).collect(Collectors.toList());
		for(int i = 0;i<taskIds.size();i++){
			Long taskId = taskIds.get(i);
			String path1 = path + "->" + taskId;
			findPostTaskA(taskIds.get(i),path1);
		}
	}
}
