package com.hushunjian.stringTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONObject;

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
		System.out.println("++++" + f.substring(0,f.length()-1));
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
		System.out.println("==========6==========");
/*		JSONObject json = JSONObject.fromObject("{id:a}");
		String string = json.getString("id");
		System.out.println(string);*/
		System.out.println("==========7==========");
		String send = "流亭机场站-结构主体施工-主体结构-站台层-混凝土中板梁";
		System.out.println(send.indexOf("-"));
		String send1 = send.substring(0, send.indexOf("-"));
		System.out.println(send1);
		String send2 = send.substring(send.indexOf("-"), send.length());
		System.out.println(send2);
		System.out.println("==========8==========");
		
		String str1 = "线路1|单位工程1|参建方1+2";
		String str2 = "线路1|单位工程2|参建方2+2";
		String str3 = "线路1|单位工程1|参建方1+2";
		String str4 = str3.replaceFirst(str1.replace("|", "\\|"), str2);
		System.out.println(str4);
		System.out.println("==========9==========");
		String source = "测试线路|郑许市域铁路工程长葛制梁场|001+测试|青岛站+测试|自建文件夹1+a";
		String regex = source.replace("|", "\\|");
		String target = "测试线路|郑许市域铁路工程长葛制梁场|001+测试|青岛站+测试|自建文件夹1+a+b";
		String name = "测试线路|郑许市域铁路工程长葛制梁场|001+测试|青岛站+测试|自建文件夹1+a";
		name = target + name.substring(source.length(), name.length());
		System.out.println(name);
		String path1 = "1.1";
		String path2 = "1.2.1";
		System.out.println(path1.compareTo(path2));
	}
}
