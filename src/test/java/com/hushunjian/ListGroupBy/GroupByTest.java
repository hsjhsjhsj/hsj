package com.hushunjian.ListGroupBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class GroupByTest {
	
	private String name;
	
	private Integer age; 

	public GroupByTest(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//List<String> planDetailIds=productionPlanDetails.stream().map(ProductionPlanDetailEntity::getId).collect(Collectors.toList());
	
	public static void main(String[] args) {
		List<GroupByTest> groupByTests = Lists.newArrayList(
				new GroupByTest("A",1),
				new GroupByTest("A",2),
				new GroupByTest("B",3),
				new GroupByTest("B",4),
				new GroupByTest("C",5),
				new GroupByTest("D",6),
				new GroupByTest("A",7)
				);
		
		Map<String, List<GroupByTest>> collect = groupByTests.stream().collect(Collectors.groupingBy(GroupByTest::getName));
		System.out.println(collect);
	}

}
