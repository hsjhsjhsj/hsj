package com.hushunjian.listSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;

public class TestTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1.1.1.1");
		list.add("1.10.1");
		list.add("1.2");
		list.add("1.4.3.1");
		list.add("1.2.1");
		list.add("1.1.1");
		list.add("1.1");
		list.add("1.3");
		list.add("1.4.2");
		list.add("1.3.1");
		list.add("1.10");
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (String string : list) {
			String[] split1 = string.split("\\.");
			
				if (2==split1[1].length()) {
					list1.add(string);
				}else {
					list2.add(string);	
				}
		}
		Collections.sort(list1);
		Collections.sort(list2);
		list2.addAll(list1);
		list2.forEach(s -> System.out.println(s));
		System.out.println("=====================1");
		List<String> outLine = Lists.newArrayList();
		outLine.add("004");
		outLine.add("004005");
		outLine.add("004004004");
		outLine.add("005");
		outLine.add("006");
		outLine.add("007");
		Collections.sort(outLine);
		outLine.forEach(o -> System.out.println(o));
	}
}
