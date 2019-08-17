package com.hushunjian.streamTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<StreamA> a = new ArrayList<>();
		a.add(new StreamA("a","a"));
		a.add(new StreamA("a","a"));
		a.add(new StreamA("a","a"));
		a.add(new StreamA("a","a"));
		List<String> b = a.stream().map(StreamA::getName).collect(Collectors.toList());
		System.out.println(b);
		System.out.println(b.size());
		System.out.println(new HashSet<>(b).size());
		System.out.println("==========1==========");
		List<Component> components = new ArrayList<>();
		components.add(new Component("fcGuid1", "datSetName11"));
		components.add(new Component("fcGuid1", "datSetName11"));
		components.add(new Component("fcGuid1", "datSetName13"));
		components.add(new Component("fcGuid1", "datSetName14"));
		
		components.add(new Component("fcGuid2", "datSetName11"));
		components.add(new Component("fcGuid2", "datSetName11"));
		components.add(new Component("fcGuid1", "datSetName23"));
		components.add(new Component("fcGuid2", "datSetName24"));
		
		Map<String, String> collect = components.stream().collect(Collectors.toMap(
				Component::getFcGuid,
				Component::getDatSetName,
                (name1, name2) -> name1.equals(name2) ? name1 : name1 + ";" + name2));
		collect.forEach((key,value) -> {
			System.out.println(key + "==" + value);
		});
		
		Set<String> dataSetNames = new HashSet<>();
		dataSetNames.add("1");
		dataSetNames.add("2");
		dataSetNames.add("3");
		System.out.println(String.join(",", dataSetNames));
	}
}
