package com.hushunjian.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {
	
	private static final Map<Integer,List<String>> map;
	
	static{
		map = new HashMap<Integer, List<String>>();
		List<String> list1 = new ArrayList<>();
		list1.add("场长:张亮");
		map.put(1, list1);
		List<String> list2 = new ArrayList<>();
		list2.add("副场长:郭京峰");
		list2.add("总工:杨金金");
		map.put(2, list2);
		List<String> list3 = new ArrayList<>();
		list3.add("施技部:于京");
		list3.add("安质部:张腾飞");
		list3.add("试验室:王杰");
		list3.add("物设部:里霞");
		list3.add("综合办:屈红艳");
		list3.add("拌合站:汤庭");
		map.put(3, list3);
		List<String> list4 = new ArrayList<>();
		list4.add("钢筋工班");
		list4.add("模板工班");
		list4.add("砼拌送工班");
		list4.add("砼浇筑工班");
		list4.add("养护工班");
		list4.add("维修工班");
		list4.add("移梁工班");
		map.put(4, list4);
	}
	
	
	public static void main(String[] args) {
		for(Integer level : map.keySet()){
			System.out.println(level);
			List<String> values = map.get(level);
			for(int i = 0;i< values.size();i++){
				System.out.println(values.get(i));
			}
		}
		
		System.out.println("==========1==========");
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println("size:" + list.size() + ";index:" + list.indexOf("1"));
	}
}
