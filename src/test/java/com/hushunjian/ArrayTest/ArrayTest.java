package com.hushunjian.ArrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTest {

	public static void main(String[] args) {
		
		String[] array1 = new String[]{"1","2"};
		test1(array1);
		for(int i = 0;i<array1.length;i++){
			System.out.println(array1[i]);
		}
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		List<String> aa = list1.stream().filter(s -> s.equals("2")).collect(Collectors.toList());
		list1 = aa;

//		test3(list1);
		//list1 = list1.stream().filter(s -> s.equals("2")).collect(Collectors.toList());
		System.out.println(list1);
		System.out.println("==========1==========");
		List<String> source = new ArrayList<>();
		source.add("1");
		source.add("2");
		source.forEach(str -> System.out.println(str));
		Object obj = source;
		List<Object> target = (List<Object>) obj;
		target.forEach(object -> System.out.println(object));
		System.out.println("==========2==========");
		List<String> list = Arrays.asList("机电施工一标段", "机电施工二标段",
	            "机电施工三标段", "机电施工四标段", "机电施工五标段", "机电施工六标段", "机电施工七标段", "机电施工八标段",
	            "机电施工九标段");
		System.out.println(list.contains("aa"));
		System.out.println(list.contains("机电施工一标段"));
		System.out.println(list.indexOf("机电施工一标段") >= 0);
	}
	
	public static void test1(String[] array1){
		List<String> list1 = new ArrayList<String>(Arrays.asList(array1));
		list1.remove("1");
		list1.toArray(array1);
	}
	
	public static void test2(List<String> list1){
		//list1.remove("1");
		List<String> list2 = list1.stream().filter(s -> s.equals("2")).collect(Collectors.toList());
		list1.clear();
		list1.addAll(list2);
		list1.size();
	}
	
	public  void test3(List<String> list1){
		//list1.remove("1");
		List<String> aa = list1.stream().filter(s -> s.equals("2")).collect(Collectors.toList());
		list1 = aa;
	}
}
