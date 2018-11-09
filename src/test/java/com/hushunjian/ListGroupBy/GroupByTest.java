package com.hushunjian.ListGroupBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.parser.SymbolTable;
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
		
		System.out.println("====================1====================");
		List<String> list1 = null;
		if(CollectionUtils.isNotEmpty(list1)){
			System.out.println("is not empty");
		}
		System.out.println("====================1====================");
		List<GroupByTest> groupByTests = Lists.newArrayList(
				new GroupByTest("A",1),
				new GroupByTest("D",6),
				new GroupByTest("A",2),
				new GroupByTest("B",3),
				new GroupByTest("B",4),
				new GroupByTest("C",5),
				new GroupByTest("A",7)
				);
		
		Map<String, List<GroupByTest>> collect = groupByTests.stream().collect(Collectors.groupingBy(GroupByTest::getName));
		System.out.println(collect);
		
		List<String> collect2 = new LinkedList<>(groupByTests.stream().map(GroupByTest::getName).collect(Collectors.toSet()));;
		System.out.println(collect2);
		
		LinkedList<String> collect3 = groupByTests.stream().map(GroupByTest::getName).distinct().collect(Collectors.toCollection(LinkedList::new));
		System.out.println(collect3);
	}

}
