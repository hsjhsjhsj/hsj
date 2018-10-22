package com.hushunjian.dataSetName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BimModelInfoTest {

	private final static List<BimModelInfo> list = new ArrayList<>();

	static {
		list.add(new BimModelInfo("楼层1", "bim1", "bim1Name", "分区1"));
		list.add(new BimModelInfo("楼层1", "bim2", "bim2Name", "分区1"));
		list.add(new BimModelInfo("楼层1", "bim3", "bim3Name", "分区2"));
		list.add(new BimModelInfo("楼层1", "bim4", "bim4Name", "分区2"));
		list.add(new BimModelInfo("楼层2", "bim1", "bim1Name", "分区1"));
		list.add(new BimModelInfo("楼层2", "bim2", "bim2Name", "分区2"));
		list.add(new BimModelInfo("楼层2", "bim3", "bim3Name", "分区3"));
		list.add(new BimModelInfo("楼层2", "bim4", "bim4Name", "分区4"));
		list.add(new BimModelInfo("楼层1", "bim4", "bim4Name", ""));
		list.add(new BimModelInfo("", "bim4", "bim4Name", "分区2"));
	}

	public static void main(String[] args) {
		String a = "1,2";
		String[] split = a.split(",");
		PlanTask planTask = new PlanTask();
		planTask.setOutLineNum("1");
		planTask.setId("1");
		for(int i = 0;i<split.length;i++){
			Map<PlanTask, List<BimModelInfo>> groupBy = groupBy1(split[i],list,planTask);
			System.out.println(groupBy.size());
		}
		System.out.println("===================1===================");
		List<PlanTask> list2 = new ArrayList<>();
		List<PlanTask> groupBy2 = groupBy2(split,list,planTask,0,list2);
		for(int i = 0;i<groupBy2.size();i++){
			System.out.println(groupBy2.get(i).toString());
		}
		System.out.println("===================2===================");
		List<PlanTask> list3 = new ArrayList<>();
		List<PlanTask> groupBy3 = groupBy3(split,list,planTask,0,list3);
		for(int i = 0;i<groupBy3.size();i++){
			System.out.println(groupBy3.get(i).toString());
		}
		Map<String, List<PlanTask>> setId = setId(groupBy3);
		for(Map.Entry<String, List<PlanTask>> entry : setId.entrySet())    
		{    
		    System.out.println(entry.getKey()+": "+entry.getValue());    
		} 

	}

	public static Map<PlanTask,List<BimModelInfo>> groupBy1(String a, List<BimModelInfo> list,PlanTask parent) {
		Map<PlanTask,List<BimModelInfo>> result = new HashMap<>();
		Map<String, List<BimModelInfo>> collect = new HashMap<>();
		switch (a) {
		case "1":// 按照楼层分组
			collect = list.stream().collect(Collectors.groupingBy(BimModelInfo::getDataSetName));
			break;
		case "2":// 按照分区分组
			collect = list.stream().collect(Collectors.groupingBy(BimModelInfo::getPartition));
			break;
		default:
			break;
		}
		// 处理结果集
		Set<String> set1 = collect.keySet();
		set1.remove("");
		List<String> list1 = new ArrayList<>(set1);
		// 保存楼层/分区数据到数据库
		for(int i = 0;i<list1.size();i++){
			PlanTask planTask = new PlanTask();
			planTask.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(),i+1));
			planTask.setParent(parent.getId());
			result.put(planTask, collect.get(list1.get(i)));
		}
		return result;
	}
	
	public static List<PlanTask> groupBy2(String[] a, List<BimModelInfo> list,PlanTask parent,int j,List<PlanTask> list2) {
		Map<String, List<BimModelInfo>> collect = new HashMap<>();
		if(j == a.length){
			for (int i = 0;i<list.size();i++){
				PlanTask planTask = new PlanTask();
				planTask.setId(String.format("%s.%s", parent.getOutLineNum(),i+1));
				planTask.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(),i+1));
				planTask.setParent(parent.getId());
				list2.add(planTask);
			}
			return list2;
		}
		switch (a[j]) {
		case "1":// 按照楼层分组
			collect = list.stream().collect(Collectors.groupingBy(BimModelInfo::getDataSetName));
			break;
		case "2":// 按照分区分组
			collect = list.stream().collect(Collectors.groupingBy(BimModelInfo::getPartition));
			break;
		default:
			break;
		}
		// 处理结果集
		Set<String> set1 = collect.keySet();
		set1.remove("");
		List<String> list1 = new ArrayList<>(set1);
		// 保存楼层/分区数据到数据库
		for(int i = 0;i<list1.size();i++){
			PlanTask planTask = new PlanTask();
			planTask.setId(String.format("%s.%s", parent.getOutLineNum(),i+1));
			planTask.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(),i+1));
			planTask.setParent(parent.getId());
			list2.add(planTask);
			groupBy2(a,collect.get(list1.get(i)),planTask,j+1,list2);
		}
		return list2;
	}
	
	public static List<PlanTask> groupBy3(String[] a, List<BimModelInfo> list,PlanTask parent,int j,List<PlanTask> list2) {
		Map<String, List<BimModelInfo>> collect = new HashMap<>();
		if(j == a.length){
			for (int i = 0;i<list.size();i++){
				PlanTask planTask = new PlanTask();
				planTask.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(),i+1));
				planTask.setParent(parent.getId());
				list2.add(planTask);
			}
			return list2;
		}
		switch (a[j]) {
		case "1":// 按照楼层分组
			collect = list.stream().collect(Collectors.groupingBy(BimModelInfo::getDataSetName));
			break;
		case "2":// 按照分区分组
			collect = list.stream().collect(Collectors.groupingBy(BimModelInfo::getPartition));
			break;
		default:
			break;
		}
		// 处理结果集
		Set<String> set1 = collect.keySet();
		set1.remove("");
		List<String> list1 = new ArrayList<>(set1);
		// 保存楼层/分区数据到数据库
		for(int i = 0;i<list1.size();i++){
			PlanTask planTask = new PlanTask();
			planTask.setOutLineNum(String.format("%s.%s", parent.getOutLineNum(),i+1));
			planTask.setParent(parent.getId());
			list2.add(planTask);
			groupBy3(a,collect.get(list1.get(i)),planTask,j+1,list2);
		}
		return list2;
	}
	
	public static Map<String,List<PlanTask>> setId(List<PlanTask> list){
		Map<String,List<PlanTask>> map = new HashMap<>();
		for(int i=0;i<list.size();i++){
			// 取出每一个planTask的父级
			String outLineNum = list.get(i).getOutLineNum();
			String key = outLineNum.substring(0,outLineNum.lastIndexOf("."));
			if(map.get(key) != null){
				map.get(key).add(list.get(i));
			}else{
				List<PlanTask> a = new ArrayList<>();
				a.add(list.get(i));
				map.put(key,a);
			}
		}
		return map;
	}
}
