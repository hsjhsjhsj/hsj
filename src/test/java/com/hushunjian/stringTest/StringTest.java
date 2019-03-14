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
		String f = "1-2-41下";
		System.out.println(f.substring(0,f.length()-1));
		String e = "1,2";
		String[] split = e.split(",");
		for (String s : split) {
			System.out.println(s);
		}
		System.out.println("==========");
		String g = " D1 ";
		System.out.println("'"+g.trim()+"'");
		System.out.println("==========1==========");
		StringBuilder message = new StringBuilder("该目录下已存在相同文件[");
		message.replace(message.length()-1, message.length(), ".");
		System.out.println(message);
	}
}
