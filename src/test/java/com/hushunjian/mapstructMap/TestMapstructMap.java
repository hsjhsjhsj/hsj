package com.hushunjian.mapstructMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class TestMapstructMap {
	
	private String meetId;
	
	private String name;
	
	public static void main(String[] args) {
		List<TestMapstructMap> list = new ArrayList<>();
		list.add(new TestMapstructMap("1","张三11"));
		list.add(new TestMapstructMap("1","张三12"));
		list.add(new TestMapstructMap("1","张三13"));
		list.add(new TestMapstructMap("1","张三14"));
		list.add(new TestMapstructMap("2","张三21"));
		list.add(new TestMapstructMap("2","张三22"));
		list.add(new TestMapstructMap("2","张三23"));
		
		Map<String, List<TestMapstructMap>> map = list.stream().collect(Collectors.groupingBy(TestMapstructMap::getMeetId));
		
		
	}

	public TestMapstructMap(String meetId, String name) {
		super();
		this.meetId = meetId;
		this.name = name;
	}
}
