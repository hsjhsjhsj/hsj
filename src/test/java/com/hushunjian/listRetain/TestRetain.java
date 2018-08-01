package com.hushunjian.listRetain;

import java.util.ArrayList;
import java.util.List;

public class TestRetain {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("1");
		l1.add("2");
		l1.add("3");
		List<String> l2 = new ArrayList<String>();
		l2.add("2");
		l2.add("3");
		// 保留相同数据
		//l1.retainAll(l2);
		// 去除相同数据
		// l1.removeAll(l2);
		// 添加数据
		l1.addAll(l2);
		System.out.println(l1.toString());
		List<String> l3 = l1.subList(0, 1);
		System.out.println(l3.toString());
		List<String> l4 = new ArrayList<String>();
		l4.add("1");
		List<String> l5 = l4.subList(0, 1);
		System.out.println("===========");
		System.out.println(l5.toString());
	}
}
