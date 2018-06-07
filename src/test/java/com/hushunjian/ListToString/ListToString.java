package com.hushunjian.ListToString;

import java.util.ArrayList;
import java.util.List;

public class ListToString {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("1");
		strs.add("11");
		strs.add("111");
		strs.add("1111");
		strs.add("11111");
		strs.add("111111");
		strs.add("1111111");
		StringBuffer a = new StringBuffer(strs.toString());
		a.replace(0, 1, "(");
		a.replace(a.length()-1, a.length(), ")");
		System.out.println(a.toString());
	}
}
