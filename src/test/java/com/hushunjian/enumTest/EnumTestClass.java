package com.hushunjian.enumTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class EnumTestClass {
	public static void main(String[] args) {
		List<EnumTest> source = new ArrayList<>();
		List<EnumTest> target = new ArrayList<>();
		EnumTest[] values = EnumTest.values();
		List<EnumTest> list = Arrays.asList(values);
		for(EnumTest value : values){
			if (!EnumTest.test_2.equals(value)) {
				target.add(value);
			}
			source.add(value);
			System.out.println(value.getValue());
		}
		list.forEach(test -> System.out.println(test.getValue()));
		System.out.println("==================1==================");
		EnumTest valueOf = EnumTest.valueOf("test_1");
		System.out.println(valueOf);
		System.out.println("==================2==================");
		System.out.println(CollectionUtils.containsAny(source, target));
	}
}
