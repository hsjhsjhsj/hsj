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
		System.out.println("==========2==========");
		
		String parentProjectName = "青岛地铁一号线";
		System.out.println(StringUtils.contains(parentProjectName, "青岛") && StringUtils.contains(parentProjectName, "一号"));
		System.out.println("==========3==========");
		String beamBlock = "YY30Z-020-D3";
		String[] split2 = beamBlock.split("-");
		String a1 = split2[2];
		System.out.println(a1.substring(1, a1.length()));
		System.out.println("==========4==========");
		System.out.println(StringUtils.containsAny(beamBlock, "D10", "D12"));
		System.out.println("==========5==========");
		String a2 = " S  dd ";
		System.out.println(StringUtils.isNotBlank(a2));
		
	}
}
