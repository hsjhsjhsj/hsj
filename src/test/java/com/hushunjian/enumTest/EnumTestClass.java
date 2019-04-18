package com.hushunjian.enumTest;

import java.util.Arrays;
import java.util.List;

public class EnumTestClass {
	public static void main(String[] args) {
		EnumTest[] values = EnumTest.values();
		List<EnumTest> list = Arrays.asList(values);
		for(EnumTest value : values){
			System.out.println(value.getValue());
		}
		list.forEach(test -> System.out.println(test.getValue()));
		
		
	}
}
