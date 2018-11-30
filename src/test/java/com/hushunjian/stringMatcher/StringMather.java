package com.hushunjian.stringMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringMather {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("重点任务1");
		list.add("重点任务2");
		list.add("重点任务9");
		list.add("重点任务3");
		list.add("重点任务4");
		list.add("重点任务10"); 
		list.add("重点任务6");
		list.add("重点任务7");
		list.add("重点任务5A");
		list.add("重点任务A5");
		
		List<String> list1 = new ArrayList<>();
		Pattern pattern = Pattern.compile("重点任务[0-9]*$");
		Matcher matcher = pattern.matcher("重点任务A10A00");
		System.out.println(matcher.matches());
		List<Integer> list2 = new ArrayList<>();
		for(String s : list){
			if(pattern.matcher(s).matches()){
				list1.add(s);
				list2.add(Integer.valueOf(Integer.valueOf(s.replaceAll("重点任务", ""))));
			}
		}
		System.out.println(list1);
		Collections.sort(list2);
		System.out.println(list2);
	}
}
