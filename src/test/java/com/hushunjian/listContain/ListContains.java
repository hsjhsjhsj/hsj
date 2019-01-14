package com.hushunjian.listContain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListContains {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("f");
		
		Date date1 = new Date();
		boolean contains = list1.contains("f");
		System.out.println(contains);
		Date date2 = new Date();
		System.out.println("contains耗时："+(date2.getTime()-date1.getTime()));
		
		Date date3 = new Date();
		list1.forEach(s ->{
			System.out.println("当前循环元素："+s);
			if ("a".equals(s)) {
				System.out.println("包含");
				return;
			}
		});
		Date date4 = new Date();
		System.out.println("使用return跳出循环耗时："+(date4.getTime()-date3.getTime()));
		
		
		Date date5 = new Date();
		list1.forEach(s ->{
			System.out.println("当前循环元素："+s);
			if ("f".equals(s)) {
				System.out.println("包含");
			}
		});
		Date date6 = new Date();
		System.out.println("不使用return跳出循环耗时："+(date6.getTime()-date5.getTime()));
		
	}
}
