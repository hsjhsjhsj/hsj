package com.hushunjian.stringTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringTest {
	public static void main(String[] args) {
		String a = null;
		String b = " ss";
		System.out.println(StringUtils.isNoneBlank(a,b));
		
		String c = "B2";
		String replaceAll = c.replaceAll("^[a-zA-Z]", "");
		System.out.println(replaceAll);
		
		System.out.println("==========");
		List<String> list = new ArrayList<>();
		list.add("D1");
		list.add("G2");
		list.add("B3");
		list.add("B4");
		list.add("B5");
		list.add("B6");
		String d = list.toString();
		System.out.println(d.substring(1,d.length()-1));
	}
}
